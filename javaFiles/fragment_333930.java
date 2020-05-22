TableColumn<Person, Person> actionsColumn = new TableColumn<>("Actions");
actionsColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

actionsColumn.setCellFactory(tc -> new TableCell<Person, Person>() {
    // ...
    Button b3 = new Button(...) ;
    HBox buttons = new HBox(5, b1, b2, b3);
    // ...

    {
         b3.disableProperty().bind(itemProperty().isNotEqualTo(personWithLatestDate));
    }

    @Override
    protected void updateItem(Person person, boolean empty) {
        super.updateItem(person, empty);
        setGraphic(empty ? null : buttons);
    }
});