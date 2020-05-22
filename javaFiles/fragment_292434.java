tableA.addColumnSortHandler(new ColumnSortEvent.Handler() {

    @Override
    public void onColumnSort(ColumnSortEvent event) {
        Column<MyObject, String> columnA = event.getColumn();
        // find columnB in tableB that corresponds to columnA in tableA
        tableB.getColumnSortList().push(new ColumnSortInfo(columnB, event.isSortAscending()));
        ColumnSortEvent.fire(tableB, tableB.getColumnSortList());
    }
});