protected void updateColumns() {

    RowFilter rowFilter = ((TableRowSorter) tblSearch.getRowSorter()).getRowFilter();

    MutableTableColumnModel columnModel = (MutableTableColumnModel) tblSearch.getColumnModel();
    // Want to reset the columns, otherwise we run into problems doing the value
    // lookup, as the table doesn't think it exists.
    // You might be able to get around it with this instead, but we need
    // to rest the view any way...
    // columnModel.getColumnByModelIndex(col);
    columnModel.setColumnVisible(0, true);
    columnModel.setColumnVisible(1, true);
    columnModel.setColumnVisible(2, true);
    columnModel.setColumnVisible(3, true);

    if (rowFilter != null) {

        Map<Integer, Boolean> mapColumns = new HashMap<Integer, Boolean>(tblSearch.getColumnCount());
        for (int row = 0; row < tblSearch.getRowCount(); row++) {

            boolean include = includeValue(row, 1, rowFilter);
            mapColumns.put(0, include);
            mapColumns.put(1, include);

            include = includeValue(row, 3, rowFilter);
            mapColumns.put(2, include);
            mapColumns.put(3, include);

        }

        for (Integer col : mapColumns.keySet()) {

            columnModel.setColumnVisible(col, mapColumns.get(col));

        }

    }

}

protected boolean includeValue(int row, int col, RowFilter filter) {

    Object value = tblSearch.getValueAt(row, col);

    boolean include = filter.include(new FilterEntry(tblSearch.getModel(), value, row));

    System.out.println("include " + value + "; include = " + include);

    return include;

}