public void start(Stage primaryStage)
{
    Pane root = new Pane();

    TextField enterText = new TextField();
    enterText.setFont(Font.font("SanSerif",20));

    textFX = new Text(150,300,"");
    Font Sanserif = Font.font("Phosphate",50);
    textFX.setFont(Sanserif);
    textFX.setFill(Color.BLUE);
    root.getChildren().add(textFX);


    textFX.textProperty().bind(enterText.textProperty());

    textFX.setOnMouseDragged(e ->{
        textFX.setX(e.getX());
        textFX.setY(e.getY());
    });     


    root.getChildren().add(enterText);
    Scene scene = new Scene(root,600,600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Text Entry");
    primaryStage.show();
}