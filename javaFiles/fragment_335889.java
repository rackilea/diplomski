Timeline timeline = new Timeline();

timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), evt -> {
    updateBoard(); // do things like moving a piece...

    if (checkLoss()) {
        // stop updates when game is lost
        timeline.stop();
    }
}));

// repeat indefinitely
timeline.setCycleCount(Animation.INDEFINITE);

timeline.play();