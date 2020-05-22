void setup() {
  size(600, 600); // Set the size of the canvas to 600x600.
}

void draw() {
  background(255);
  stroke(200); // Set the stroke color to black

  int distVertLine = width / 10; // This variable defines the distance between each subsequent vertical line.
  for(int i = 0; i < width; i += distVertLine) {
    line(i, 0, i, height); // Draw a line at x=i starting at the top of the canvas (y=0) and going to the bottom (y=height)
  }

  int distHorizLine = height / 10; // This variable defines the distance between each subsequent vertical line.
  for(int i = 0; i < width; i += distHorizLine) {
    line(0, i, width, i); // Draw a line at y=i starting at the left of the canvas (x=0) and going to the right (x=width)
  }

  stroke(0); // Set the stroke to black.

  // Use a nested for loop to iterate through all grid vertices.
  for(int x = 0; x <= width; x += width/10) {
    for(int y = 0; y <= height; y += height/10) {
      PVector v = new PVector(mouseX - x, mouseY - y); // Define a vector that points in the direction of the mouse from each grid point.
      PVector u = v.setMag(15); // Make the vector have a length of 15 units.

      line(x, y, x + u.x, y + u.y); // Draw a line from the grid vertex to the terminal point given by the vector.
    }
  }
}