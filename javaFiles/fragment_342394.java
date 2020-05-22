public Obstacle getObstacleTouched(int touchX, int touchY) {
    Obstacle obstacleToReturn = null;
    for (Obstacle item : obstacles) {
        if(item.wasHit(touchX, touchY) {
            obstacleToReturn = item;
            break;
        }
    }
    return listToReturn;
}