// I'm creating a bunch of variables here because I don't know
// what properties your objects have available.
int ballLeftSide     = ball.getCenterX() - ball.getRadius();
int ballRightSide    = ball.getCenterX() + ball.getRadius();
int ballTopSide      = ball.getCenterY() - ball.getRadius();
int ballBottomSide   = ball.getCenterY() + ball.getRadius();
int paddleLeftSide   = paddle.getTopLeftX();
int paddleRightSide  = paddle.getTopLeftX() + paddle.getWidth();
int paddleTopSide    = paddle.getTopLeftY();
int paddleBottomSide = paddle.getTopLeftY() + paddle.getHeight();

bool ballOverlapsPaddle = ((ballLeftSide < paddleRightSide) &&
                           (ballRightSide > paddleLeftSide) &&
                           (ballTopSide < paddleBottomSide) &&
                           (ballBottomSide > paddleTopSide))

// Only change ball direction if the ball hasn't already passed
// the paddle. In this case, "passed" means the ball's center is
// further down than the bottom of the paddle.
if ((ballOverlapsPaddle) && (ball.getCenter() < paddleBottomSide))
    ball.setDirectionY(UPWARDS);