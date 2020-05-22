Label contextMenuLabel = new Label();
grid.add(contextMenuLabel, 0, 0); // Add to the same grid after adding the chart
contextMenuLabel.setPrefSize(width, height);
contextMenuLabel.setMinSize(width, height);
contextMenuLabel.setMaxSize(width, height);

ContextMenu contextMenu = new ContextMenu();

contextMenuLabel.setContextMenu(contextMenu);