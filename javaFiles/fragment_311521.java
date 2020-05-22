final LongProperty lastUpdateTime = new SimpleLongProperty(0);
final AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long timestamp) {
        if (lastUpdateTime.get() > 0) {
            long elapsedTime = timestamp - lastUpdateTime.get();
            checkCollisions(ballContainer.getWidth(), ballContainer.getHeight());
            updateWorld(elapsedTime);
            frameStats.addFrame(elapsedTime);
        }
        lastUpdateTime.set(timestamp);
    }
};
timer.start();