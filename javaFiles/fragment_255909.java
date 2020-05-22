TitledPane titledPane = new TitledPane(); // or TitledPane(null,content)
    BorderPane borderPane = new BorderPane();
    Label titleOfTitledPane = new Label("SomeText");
    Button buttonClose = new Button("X");
    borderPane.setCenter(titleOfTitledPane);
    borderPane.setLeft(buttonClose);
    borderPane.prefWidthProperty().bind(scene.widthProperty().subtract(40));
    titledPane.setGraphic(borderPane);