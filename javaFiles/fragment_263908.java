void draw() {
  background(255);
  translate(400, 400);
  for (int i = int(hearts-1); i >= 0; i--) {
    fill((i/(hearts-1))*255);
    float scale = 1 + i * step;
    pushMatrix();
    scale(scale);
    strokeWeight(1.0 / scale);
    heart();
    popMatrix();
  }
  saveFrame("line-######.png");
}