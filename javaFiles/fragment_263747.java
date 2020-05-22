@Override
public void start(Stage primaryStage) {
    Label label = new Label("Hello World!");
    label.setTextFill(Color.WHITE);

    Pane content = new Pane(label);
    content.setPrefSize(2000, 2000);
    content.setBackground(new Background(new BackgroundFill(
            new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.RED), new Stop(1, Color.BLUE)),
            CornerRadii.EMPTY,
            Insets.EMPTY)));

    ScrollPane scrollPane = new ScrollPane(content);

    double targetX = 10;
    double targetY = 10;

    InvalidationListener listener = o -> {
        Bounds viewportBounds = scrollPane.getViewportBounds();
        Bounds contentBounds = content.getBoundsInLocal();
        Bounds labelBounds = label.getBoundsInLocal();

        double factorX = Math.max(contentBounds.getWidth() - viewportBounds.getWidth(), 0);
        double factorY = Math.max(contentBounds.getHeight() - viewportBounds.getHeight(), 0);

        label.setTranslateX(targetX + scrollPane.getHvalue() * factorX - labelBounds.getMinX());
        label.setTranslateY(targetY + scrollPane.getVvalue() * factorY - labelBounds.getMinY());
    };

    scrollPane.viewportBoundsProperty().addListener(listener);
    scrollPane.hvalueProperty().addListener(listener);
    scrollPane.vvalueProperty().addListener(listener);
    label.boundsInLocalProperty().addListener(listener);

    Scene scene = new Scene(scrollPane, 200, 200);

    primaryStage.setScene(scene);
    primaryStage.show();

    listener.invalidated(null);
}