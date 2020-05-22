StringProperty style = new SimpleStringProperty();

// ...

table.setRowFatory(tv -> {
    TableRow<MyDataType> row = new TableRow<>();
    row.styleProperty().bind(style);
    return row ;
});