float amount = 0;
float speed = .001;

void setup() {
  size(500, 500);
}

void draw() {

  float startX = 0;
  float startY = 0;
  float endX = width;
  float endY = height;
  float currentX = lerp(startX, endX, amount);
  float currentY = lerp(startY, endY, amount);

  background(0);
  ellipse(currentX, currentY, 20, 20);

  amount += speed;

}