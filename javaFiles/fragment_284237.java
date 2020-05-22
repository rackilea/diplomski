TableView<InterfaceModel> table = new TableView<>();
TableViewContextMenuBuilder.create(InterfaceModel.class)
    .menuBuilder.addItem("Edit", this::edit);
    .menuBuilder.addItem("Item 2", this::handleOtherItem);
    // ...
    .buildForTable(table);