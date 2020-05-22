@FXML
protected void solveClicked(ActionEvent event) {
    Runnable[] steps = new Runnable[] {this::L, this::R, this::F, this::B};
    createTimeline(steps, 500).play();
}

private Timeline createTimeline(Runnable[] steps, int delay) {
    Duration frameTime = Duration.millis(delay);
    Duration increment = Duration.millis(delay);
    Timeline timeline = new Timeline() ;
    for (Runnable step : steps) {
        timeline.getKeyFrames().add(new KeyFrame(frameTime, e -> step.run()));
        frameTime = frameTime.add(increment);
    }
    return timeline ;
}