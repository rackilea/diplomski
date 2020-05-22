public void AI(Paddle paddle) {
    RectF paddleRect = paddle.getRect();
    RectF ballRect = ball.getRect();
    float ballCenter = (ballRect.left + ballRect.right) / 2;
    float paddleCenter = (paddleRect.left + paddleRect.right) / 2;
    if (ballCenter < paddleCenter) {
        setMovementState(LEFT);
    }
    else {
        setMovementState(RIGHT);
    }
}