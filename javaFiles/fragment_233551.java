treeTable.setRowFactory(ttv -> {
    ContextMenu contextMenu = new ContextMenu();
    MenuItem inviteMenuItem = new MenuItem("Invite to Chat");
    // ...
    MenuItem banMenuItem = new MenuItem("Ban");
    // ...
    TreeTableRow<MyDataType> row = new TreeTableRow<MyDataType>() {
        @Override
        public void updateItem(MyDataType item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setContextMenu(null);
            } else {
                // configure context menu with appropriate menu items, 
                // depending on value of item
                setContextMenu(contextMenu);
            }
        }
    };
    inviteMenuItem.setOnAction(evt -> {
        MyDataType item = row.getItem();
        // do something with item...
    });
    // event handlers for other menu items...
    return row ;
});