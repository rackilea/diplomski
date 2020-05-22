public void hitDetection() {
    ArrayList<Rect> listOfBounds = obstacleManager.getObstacleBounds();
    for(Rect bound : listOfBounds) {
        // Do you stuff
        // Note the here, you are receiving a list of Rects only.
        // So, you can only check if a hit happened.. but you can't update the Obstacles because here, you don't have access to them.
        // Nothing stops you of receiving the whole list of items if you want to(like the reference of ObstacleManager.obstacles).
    }
}