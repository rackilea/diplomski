@Override
public void start(Stage primaryStage) throws Exception {
    GreaterCell tile31 = new GreaterCell("3", LOWER, LOWER, GREATER, EQUAL);
    GreaterCell tile41 = new GreaterCell("6", LOWER, GREATER, GREATER, GREATER);
    GreaterCell tile51 = new GreaterCell("5", GREATER, EQUAL, LOWER, LOWER);
    HBox root = new HBox(0, new Group(tile31), new Group(tile41), new Group(tile51));
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(40));
    Scene scene = new Scene(root, 400, 250);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());        
    primaryStage.setScene(scene);
    primaryStage.show();
}