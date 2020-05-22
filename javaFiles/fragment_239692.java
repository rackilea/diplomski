public void initComponents(){

    //Left components
    goBackLeft = new Button("<<");
    gridPane.add(goBackLeft, 0, 0);

    playButtonLeft = new Button("Play");
    playButtonLeft.setMaxWidth(Double.MAX_VALUE);
    GridPane.setFillWidth(playButtonLeft, true);
    gridPane.add(playButtonLeft, 1, 0);

    goForwardLeft = new Button(">>");
    gridPane.add(goForwardLeft, 2, 0);

    songFieldLeft = new TextField();
    songFieldLeft.setEditable(false);
    gridPane.add(songFieldLeft, 0, 1);
    GridPane.setColumnSpan(songFieldLeft, 3);

    pickButtonLeft = new Button("Pick Song");
    pickButtonLeft.setMaxWidth(Double.MAX_VALUE);
    GridPane.setFillWidth(pickButtonLeft, true);
    gridPane.add(pickButtonLeft, 1, 2);

    //End Left

    //Right components
    goBackRight = new Button("<<");
    gridPane.add(goBackRight, 4, 0);

    playButtonRight = new Button("Play");
    playButtonRight.setMaxWidth(Double.MAX_VALUE);
    GridPane.setFillWidth(playButtonRight, true);
    gridPane.add(playButtonRight, 5, 0);

    goForwardRight = new Button(">>");
    gridPane.add(goForwardRight, 6, 0);

    songFieldRight = new TextField();
    songFieldRight.setEditable(false);
    gridPane.add(songFieldRight, 4, 1);
    GridPane.setColumnSpan(songFieldRight, 3);

    pickButtonRight = new Button("Pick Song");
    pickButtonRight.setMaxWidth(Double.MAX_VALUE);
    GridPane.setFillWidth(pickButtonRight, true);
    gridPane.add(pickButtonRight, 5, 2);

    //End right

    mashButton = new Button("Mash!");
    gridPane.add(mashButton, 3, 3);

    gridPane.setHgap(10);
    gridPane.setVgap(15);
    gridPane.setPadding(new Insets(10, 10, 10, 10));

}