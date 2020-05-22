Timeline timer = new Timeline(new KeyFrame(
        Duration.millis(10),
        event -> {//Same for loop as above}
));
timer.setCycleCount(Timeline.INDEFINITE);
timer.play();