@Override
public void start(Stage primaryStage) {
    Button btn = new Button("If you can read this, the blur isn't working!");

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    root.setStyle("-fx-background-color: black;");
    ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
    GaussianBlur blur = new GaussianBlur(55); // 55 is just to show edge effect more clearly.
    adj.setInput(blur);
    root.setEffect(adj);

    Scene scene = new Scene(root, 500, 200, null);

    btn.setOnAction((ActionEvent event) -> {
        scene.setFill(scene.getFill() == Color.BLACK ? null : Color.BLACK);
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}