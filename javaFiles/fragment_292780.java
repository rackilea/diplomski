void draw() {
  background(255);
  for (int i = 0; i < 10; i++) {
    image(loadImages(i), i*128, 0); // i * 128 to draw the image side by side, or else you'll only see the last one you draw
  }
}