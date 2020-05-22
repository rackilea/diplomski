public void hitDetection(int touchX, int touchY) {
    Obstacle objectHit = obstacleManager.getObstacleTouched(int touchX, int touchY);
    if (objectHit != null) {
        objectHit.doStuffAlpha();
        objectHit.doStuffBeta();
    } else {
        // No obstacle was hit.. Nothing to do
    }
}