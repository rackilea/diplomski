private void accelerateX(float speed) {
    moveSpeed += (float) (speed * 0.0096);
    if (moveSpeed >= MAX_MOVE_SPEED) {
        moveSpeed = MAX_MOVE_SPEED;
    } else if (moveSpeed <= -MAX_MOVE_SPEED) {
        moveSpeed = -MAX_MOVE_SPEED;
    }
}