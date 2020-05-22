private static final class ContextMenuCell extends TreeCell {

    ContextMenuCell() {
        setContextMenu(new ContextMenu(new MenuItem("Test")));
    }

    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.toString());
            setGraphic(getTreeItem().getGraphic());
        }
    }
}