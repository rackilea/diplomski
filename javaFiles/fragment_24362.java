public void start(Stage stage){
    // create the scene
    stage.setTitle("WhitePlay");
    browser = new Browser();
    BorderPane root = new BorderPane();
    root.setCenter(browser);
    Button button = new Button("Play");
    root.setBottom(button);
    button.setOnAction(a -> System.out.println("Play"));
    scene = new Scene(root, 992, 620, Color.web("#000000"));
    stage.setScene(scene);
    stage.show();
}