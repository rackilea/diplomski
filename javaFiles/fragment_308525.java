void setup() {
  Paddle paddle = new Paddle();
  Ball ball = new Ball();
  ball.paddle = paddle;
  ball.testBall();
}

class Paddle {
  void testPaddle() {
    println("paddle");
  }
}

class Ball {
  Paddle paddle; 

  void testBall() {
    println("ball");
    paddle.testPaddle();
  }
}