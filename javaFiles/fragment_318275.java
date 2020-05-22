class Ball {

  float x;
  float y;

  void setPosition(float x, float y) {
    this.x = x;
    this.y = y;
  }

  void drawBall() {
    fill(ballColor);
    ellipse(x, y, 25, 25);
  }
}