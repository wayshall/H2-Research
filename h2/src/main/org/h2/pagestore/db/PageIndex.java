/*
 * Copyright 2004-2021 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.pagestore.db;

import org.h2.index.Index;
import org.h2.index.IndexType;
import org.h2.table.IndexColumn;
import org.h2.table.Table;

/**
 * A page store index.
 */
public abstract class PageIndex extends Index {

    /**
     * The root page of this index.
     */
    protected int rootPageId;

    private boolean sortedInsertMode;

    /**
     * Initialize the page store index.
     *
     * @param newTable the table
     * @param id the object id
     * @param name the index name
     * @param newIndexColumns the columns that are indexed or null if this is
     *            not yet known
     * @param uniqueColumnCount count of unique columns
     * @param newIndexType the index type
     */
    protected PageIndex(Table newTable, int id, String name, IndexColumn[] newIndexColumns, int uniqueColumnCount,
            IndexType newIndexType) {
        super(newTable, id, name, newIndexColumns, uniqueColumnCount, newIndexType);
    }

    /**
     * Get the root page of this index.
     *
     * @return the root page id
     */
    public int getRootPageId() {
        return rootPageId;
    }

    /**
     * Write back the row count if it has changed.
     */
    public abstract void writeRowCount();

    @Override
    public void setSortedInsertMode(boolean sortedInsertMode) {
        this.sortedInsertMode = sortedInsertMode;
    }

    boolean isSortedInsertMode() {
        return sortedInsertMode;
    }

}
