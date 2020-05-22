HBox box = new HBox();
    box.getChildren().addAll(...);        

    MenuItem editMenu = new MenuItem("Edit");
    editMenu.setOnAction(e -> {
        // Do something
    });

    MenuItem deleteMenu = new MenuItem("Delete");
    deleteMenu.setOnAction(e -> {
        // Do something
    });

    ContextMenu menu = new ContextMenu(editMenu, deleteMenu);
    box.setOnContextMenuRequested(e -> {
        menu.show(box.getScene().getWindow(), e.getScreenX(), e.getScreenY());
    });