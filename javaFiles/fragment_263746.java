@Override
public void start(Stage primaryStage) {
    Region content = new Region();
    content.setPrefSize(2000, 2000);
    content.setBackground(new Background(new BackgroundFill(
            new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.RED), new Stop(1, Color.BLUE)),
            CornerRadii.EMPTY,
            Insets.EMPTY)));

    Label label = new Label("Hello World!");
    label.setTextFill(Color.WHITE);
    StackPane.setAlignment(label, Pos.TOP_LEFT);
    StackPane.setMargin(label, new Insets(10));

    ScrollPane scrollPane = new ScrollPane(content);

    StackPane root = new StackPane();
    root.getChildren().addAll(scrollPane, label);

    Scene scene = new Scene(root, 200, 200);

    primaryStage.setScene(scene);
    primaryStage.show();
}