@Override
public void start(Stage primaryStage) throws Exception {
    Color fromColor = Color.BLACK;
    Color toColor = Color.ORANGE;

    Label label = new Label("hello world!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(label.textFillProperty(), fromColor)),
            new KeyFrame(Duration.seconds(10), new KeyValue(label.textFillProperty(), toColor))
    );
    timeline.play();
    Scene scene = new Scene(new StackPane(label));
    primaryStage.setScene(scene);
    primaryStage.show();
}