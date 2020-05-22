for (ObservableList<Stitch> row : pattern) {
    // if this row contains more elements than columns we have already created,
    // (must be true on first row, may be true on subsequent rows if data not rectangular)
    // create a new column for each additional element
    for (int i = pattern.getColumns().size(); i < row.size() ; i++) {
        TableColumn<ObservableList<Stitch>, Color> column = new TableColumn<>();
        final int columnIndex = i ;
        column.setCellValueFactory( rowData -> 
            rowData.getValue() // the row value, i.e. an ObservableList<Stitch>
                .get(columnIndex) // the Stitch for this cell
                .getDisplayColorProperty() );

        column.setCellValueFactory(col -> new StitchCell());

        column.setMinWidth(10);
        column.setMaxWidth(10);
        pattern.getColumns().add(column);
    }
}