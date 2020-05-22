Duration deltaTime = Duration.ZERO;
Instant beginTime = Instant.now();
while(!windowIsClosed){

    animations(deltaTime);
    repaint();

    deltaTime = Duration.between(beginTime, Instant.now());
}