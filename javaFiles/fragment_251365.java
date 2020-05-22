@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Say 'Hello World'");
    btn.setOnAction((ActionEvent event) -> {
        System.out.println("Hello World!");
    });
    Region region = new Region();
    region.setStyle("-fx-background-color: #0000ff88;");
    region.setMouseTransparent(true);

    StackPane root = new StackPane(btn, region);

    Scene scene = new Scene(root, 100, 100);

    primaryStage.setScene(scene);
    primaryStage.show();
}