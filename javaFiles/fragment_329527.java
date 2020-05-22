PImage img;

SpaceShip() {
  // Images must be in the "data" directory to load correctly
  img = loadImage("spaceship.jpg");
  ...
}

void show() {
  image(img, x, y);
}