PImage img;

void setup() {
  // Images must be in the "data" directory to load correctly
  img = loadImage("myImage.jpg");
}

void draw() {
  image(img, 0, 0);
}