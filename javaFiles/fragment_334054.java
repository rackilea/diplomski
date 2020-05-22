ObjectProperty<Person> criticalPerson = new SimpleObjectProperty<>();

personTable.setRowFactory(tv -> {
    TableRow<Person> row = new TableRow<>();
    BooleanBinding critical = row.itemProperty().isEqualTo(criticalPerson);
    row.styleProperty().bind(Bindings.when(critical)
        .then("-fx-background-color: red ;")
        .otherwise(""));
    return row ;
});