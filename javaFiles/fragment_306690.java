// min distance to Pane bounds
private static final double OFFSET = 25;

@Override
public void start(Stage primaryStage) {
    Text text = new Text("A reallyyy big teeeeexxxxxxxxxxxxxxxxxxxxxxxt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    text.setLayoutY(25);
    text.setManaged(false);
    text.setLayoutX(OFFSET);

    Pane pane = new Pane(text);
    pane.setMinHeight(50);

    Timeline timeline = new Timeline();

    KeyFrame updateFrame = new KeyFrame(Duration.seconds(1 / 60d), new EventHandler<ActionEvent>() {

        private boolean rightMovement;

        @Override
        public void handle(ActionEvent event) {
            double tW = text.getLayoutBounds().getWidth();
            double pW = pane.getWidth();
            double layoutX = text.getLayoutX();

            if (2 * OFFSET + tW <= pW && layoutX >= OFFSET) {
                // stop, if the pane is large enough and the position is correct
                text.setLayoutX(OFFSET);
                timeline.stop();
            } else {
                if ((rightMovement && layoutX >= OFFSET) || (!rightMovement && layoutX + tW + OFFSET <= pW)) {
                    // invert movement, if bounds are reached
                    rightMovement = !rightMovement;
                }

                // update position
                if (rightMovement) {
                    layoutX += 1;
                } else {
                    layoutX -= 1;
                }
                text.setLayoutX(layoutX);
            }
        }
    });

    timeline.getKeyFrames().add(updateFrame);
    timeline.setCycleCount(Animation.INDEFINITE);

    // listen to bound changes of the elements to start/stop the animation
    InvalidationListener listener = o -> {
        double textWidth = text.getLayoutBounds().getWidth();
        double paneWidth = pane.getWidth();
        if (textWidth + 2 * OFFSET > paneWidth
                && timeline.getStatus() != Animation.Status.RUNNING) {
            timeline.play();
        }
    };

    text.layoutBoundsProperty().addListener(listener);
    pane.widthProperty().addListener(listener);

    Scene scene = new Scene(pane);

    primaryStage.setScene(scene);
    primaryStage.show();
}