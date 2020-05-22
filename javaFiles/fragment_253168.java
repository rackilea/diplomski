BorderPane pane = new BorderPane();
pane.setLeft(anchorpane);
pane.setCenter(root);
pane.setRight(grid);
pane.setTop(flow);
pane.setBottom(tile);

Scene scene = new Scene(pane, 300, 250);