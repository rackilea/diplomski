TilePane tile = new TilePane();
tile.setPadding(new Insets(10, 10, 10, 10));
tile.setPrefColumns(2);
tile.setStyle("-fx-background-color: #CD5C5C;");
HBox hbox2 = new HBox(8); // spacing = 8
hbox2.getChildren().addAll(top, left, center);
tile.getChildren().add(hbox2);