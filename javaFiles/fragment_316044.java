int CIRCLE_SIZE = 50;

void setup()
{
  size(200, 200);
  background(20);
}

void draw()
{
  int red = 100;
  fill(red, 0, 0);
  ellipse(100, 100, CIRCLE_SIZE, CIRCLE_SIZE);
}