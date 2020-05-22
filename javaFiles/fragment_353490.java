public void startTimer() {
    Timeline timeline = new Timeline();
    timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, event -> {
        int i = random.nextInt(strings.size());
        setRandomString(strings.get(i));
    }));
    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1)));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
}