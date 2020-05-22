private void attachContextMenu() {
    CustomMenuItem item = FilterPanel.getInMenuItem(this);

    ContextMenu contextMenu = new ContextMenu();
    contextMenu.getStyleClass().add("column-filter");

    contextMenu.getItems().add(item);
    tableColumn.setContextMenu(contextMenu);
}