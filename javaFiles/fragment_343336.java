PFont fontA;

void setup() {
  size(300, 100);
  fill(0);
  fontA = loadFont("ArialMT-20.vlw");
  textFont(fontA, 20);
  // Background drawn once here
  background(255);
}

void draw() {
  // When mouse is held down, the background is wiped
  if (mousePressed) {
    background(255);
  }
  text("Hi there", 20, 50);
}