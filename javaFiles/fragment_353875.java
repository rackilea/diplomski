public void collidePaddle(int collidePos){
    if (collidePos >= 50) {
        direction = (50-collidePos)*180/50;
        // Correct the position of the ball to meet the minimum requirements
        // of the collision...
    } else if (collidePos <= 0) {
        direction = (50-collidePos)*180/50;
        // Correct the position of the ball to meet the minimum requirements
        // of the collision...
    }
}