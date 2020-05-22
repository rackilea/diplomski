public final Table getTable() {
    final Table table = new Table(dataTableObject,
            TableView.createTableOptions(dataTableObject));
    SortHandler sortHandler = new SortHandler() {

        @Override
        public void onSort(SortEvent event) {
            if (event.getColumn() == 0) {
                if (dataTableObject.getColumnLabel(event.getColumn()).contains("Time")
                        || dataTableObject.getColumnLabel(event.getColumn()).contains(
                                "Frequency")) {
                    reverseRowOrder(); //reverses the order of the rows in dataTableObject
                    table.draw(dataTableObject, TableView.createTableOptions(dataTableObject));
                }
            }
        }
    };
    table.addSortHandler(sortHandler);
    return table;
}