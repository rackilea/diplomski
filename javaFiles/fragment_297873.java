@Override
public void start(Stage primaryStage) {
    Scene scene = new Scene(getPan(), 800, 600);

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        getPan().diminuerRect(35);
    }));
    timeline.setCycleCount(5);
    timeline.play();

    primaryStage.setScene(scene);
    primaryStage.show();
}