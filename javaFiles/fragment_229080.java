// Create the tree
CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String>("All stuff");
rootItem.setExpanded(true);                  

final TreeView<String> tree = new TreeView<String>(rootItem);  
tree.setEditable(true);

tree.setCellFactory(CheckBoxTreeCell.<String>forTreeView());    
for (int i = 0; i < 8; i++) {
    final CheckBoxTreeItem<String> checkBoxTreeItem = 
            new CheckBoxTreeItem<String>("Stuff" + (i+1));
    rootItem.getChildren().add(checkBoxTreeItem);                
}

tree.setRoot(rootItem);
tree.setShowRoot(true);

// Create a custom menu item
CustomMenuItem customMenuItem = new CustomMenuItem(tree);
customMenuItem.setHideOnClick(false);

// Create the menu button
MenuButton mb = new MenuButton("Stuffs");
mb.getItems().add(customMenuItem);