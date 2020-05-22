TableView<Item> table = new TableView<>(FXCollections.observableArrayList(
        new Item("ok"),
        new Item("bad"),
        new Item("good")));
TableColumn<Item, String> typeColumn = new TableColumn<>("type");
typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

table.setRowFactory(tv -> {
    TableRow<Item> row = new TableRow<>();
    StringBinding typeBinding = Bindings.selectString(row.itemProperty(), "type");

    row.backgroundProperty().bind(Bindings.createObjectBinding(()
            -> new Background(new BackgroundFill(typeToColor(typeBinding.get()), CornerRadii.EMPTY, Insets.EMPTY)), typeBinding));
    return row;
});

table.getColumns().add(typeColumn);