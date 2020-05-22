CTTableColumns ctColumns = ctTable.addNewTableColumns();
    CTAutoFilter autofilter = ctTable.addNewAutoFilter();
    ctColumns.setCount(table_headers.size());

    for(int i = 0; i < table_headers.size(); i++) {
        CTTableColumn column = ctColumns.addNewTableColumn();
        column.setName(table_headers.get(i));
        column.setId(i + 1);
        CTFilterColumn filter = autofilter.addNewFilterColumn();
        filter.setColId(i + 1);
        filter.setShowButton(true);
    }