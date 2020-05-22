Pane blackPane = new Pane();
    blackPane.setId("blackPane");
    screen = new TextArea();
    screen.setId("screen");
    screen.setEditable(false);
    blackPane.getChildren().add(screen);
    gridPane.add(blackPane, 0, row, 4, 1);