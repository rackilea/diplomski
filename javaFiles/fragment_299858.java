private static Label createLabel(int num, boolean mark) {
    Label label = new Label(Integer.toString(num));
    label.setPrefSize(50, 50);
    label.setMaxSize(Double.MAX_VALUE, Region.USE_PREF_SIZE);
    label.setStyle(mark ? "-fx-background-color: #FFFFFF" : "-fx-background-color: #BBBBBB;");
    return label;
}

@Override
public void start(Stage primaryStage) throws Exception {
    VBox scale = new VBox();
    scale.setMinHeight(Region.USE_PREF_SIZE);
    GridPane content = new GridPane();

    for (int i = 0; i < 40; i++) {
        boolean b = ((i % 2) == 0);
        scale.getChildren().add(createLabel(i, !b));

        for (int j = 0; j < 10; j++) {
            content.add(createLabel(i * 10 + j, b), j, i);
        }
    }

    AnchorPane scaleContainer = new AnchorPane(scale);
    scaleContainer.setMinWidth(30);
    scaleContainer.setMinHeight(0);
    AnchorPane.setLeftAnchor(scale, 0d);
    AnchorPane.setRightAnchor(scale, 0d);

    Rectangle clip = new Rectangle();
    scaleContainer.setClip(clip);
    clip.widthProperty().bind(scaleContainer.widthProperty());
    clip.heightProperty().bind(scaleContainer.heightProperty());

    ScrollPane scroll = new ScrollPane(content);

    scale.translateYProperty().bind(Bindings.createDoubleBinding(() -> {
        double contentHeight = content.getHeight();
        double viewportHeight = scroll.getViewportBounds().getHeight();
        if (contentHeight <= viewportHeight) {
            return 0d;
        } else {
            return -scroll.getVvalue() * (contentHeight - viewportHeight);
        }
    }, scroll.viewportBoundsProperty(), scroll.vvalueProperty(), content.heightProperty()));

    HBox root = new HBox(scaleContainer, scroll);
    root.setPadding(new Insets(10));

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}