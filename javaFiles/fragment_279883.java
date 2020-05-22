double ty = player.getTranslateY();

// quadratic interpolation to simulate gravity
Interpolator interpolator = new Interpolator() {
    @Override
    protected double curve​(double t) {
        return t * (2 - t);
    }

};
Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
                                              new KeyValue(player.translateYProperty(), ty, interpolator)),
                                 new KeyFrame(Duration.seconds(1),
                                              new KeyValue(player.translateYProperty(), ty-40, interpolator)));

// play forward once, then play backward once
timeline.setCycleCount(2);
timeline.setAutoReverse(true);

JumpBtn.setDisable(true);
timeline.setOnFinished(evt -> JumpBtn.setDisable(false));

timeline.play();