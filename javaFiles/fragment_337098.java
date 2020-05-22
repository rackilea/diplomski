TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>();
table.setRowSorter(trs);

// Create the row filder...
trs.setRowFilter(new RowFilter<TableModel, Integer>() {

    @Override
    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
        boolean include = false;
        // Returns the value for the specific column...
        CustomObject value = (CustomObject)entry.getValue(filterColumn);
        if (filterBySuper) {
            include = value.isSuper();
        } else {
            include = value.getName().startsWith(fistPart) && value.getName().endWith(lastPart);
        }
        return include;
    }
});