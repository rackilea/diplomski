private PauseTransition timer;

private void startTimer() {
    btn.setVisible(true);
    btn2.setVisible(true);
    timer.playFromStart();
}

private void stopTimer() {
    btn.setVisible(true);
    btn2.setVisible(true);
    timer.stop();
}

private Button btn, btn2;

@Override
public void start(Stage primaryStage) {
    timer = new PauseTransition(Duration.seconds(3));

    btn = new Button("Button 1");
    btn2 = new Button("Button 2");

    timer.setOnFinished(evt -> {
        btn.setVisible(false);
        btn2.setVisible(false);
    });

    EventHandler<MouseEvent> buttonMouseMoveHandler = evt -> {
        evt.consume();
        stopTimer();
    };

    btn.setOnMouseMoved(buttonMouseMoveHandler);
    btn2.setOnMouseMoved(buttonMouseMoveHandler);

    VBox box = new VBox(100, btn, btn2);

    StackPane root = new StackPane(new Group(box));

    Scene scene = new Scene(root, 500, 500);
    scene.setOnMouseMoved(evt -> {
        startTimer();
    });

    startTimer();

    primaryStage.setScene(scene);
    primaryStage.show();
}