float x, y, radius;

void setup () {
  size(500, 500);
  radius = 200;
}

void draw () {
  background(255);

  pushMatrix();
  translate(width/2, height/2);
  line(-200, 0, 200, 0);
  line(0, -200, 0, 200);

  x = radius*cos(radians(30));
  y = radius*sin(radians(30));

  line(0, 0, x, y);
  popMatrix();
}