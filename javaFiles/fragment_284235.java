TableView<InterfaceModel> table = new TableView<>();
ContextMenuHelper helper = new ContextMenuHelper();
table.setRowFactory(t -> {
    TableRow<InterfaceModel> row = new TableRow<>();
    ContextMenu menu = new ContextMenu();
    row.setContextMenu(menu);
    menu.getItems().addItem(helper.createItem("Edit", row, this::edit));
    // etc...
});