Ball ball = new Ball();

color ballColor = #00ff00;

void setup(){
  size(500, 500);
}

void draw(){
  background(0);
  ball.setPosition(mouseX, mouseY);
  ball.drawBall();
}