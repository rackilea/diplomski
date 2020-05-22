public class ContextMenuCell extends TreeCell<String> {

        private ContextMenu menu;

        public ContextMenuCell() {
            Label lbl = new Label("Add item");
            MenuItem menuItem = new CustomMenuItem(lbl);

            lbl.setOnMouseClicked(evt -> {
                if (evt.getButton() != MouseButton.PRIMARY) {
                    return;
                }

                TreeItem treeItem =
                        new TreeItem<String>("New item");

                if (getTreeItem().isLeaf()) {
                    getTreeItem().getParent().getChildren().add(getIndex(), treeItem);
                } else {
                    getTreeItem().getChildren().add(0, treeItem);
                }

            });

            menu = new ContextMenu(menuItem);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item);
                setGraphic(getTreeItem().getGraphic());
                setContextMenu(menu);
            }
        }
    }