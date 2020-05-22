//red
Rectangle red;

//all other rectangles
ArrayList <Rectangle> rectList;

float speed = 2;
//float cspeed = 2;

void setup() {
  size(800, 800);
  noStroke();
  noSmooth();
  noCursor();

  // Initializing Red square
  red = new Rectangle(200, 375, 50, 50, color(255, 0, 0));
  // Initializing a bunch of rectangles
  rectList = new ArrayList <Rectangle>();
  rectList.add(new Rectangle(550, 375, 50, 50, color(0, 0, 255)));  // Red
  rectList.add(new Rectangle(300, 500, 50, 50, color(0, 255, 0)));  // Green
  // you can add as many as you want
}

void draw() {
  surface.setTitle(mouseX + ", " + mouseY);
  background(50);
  move();
  display();
}

void display() {
  red.Render();

  // this is a java 'For Each' loop. Research it, it's very useful.
  for ( Rectangle r : rectList) {
    r.Render();
  }
}

void move() {
  //Red square movement
  float moveX = 0;
  float moveY = 0;

  if (keyPressed) {
    // We're going calculate up how much we want to move the red square first
    // Then we'll check for collisions
    // Then we'll move the square (it there are no collisions)
    if (key == 'd' || key == 'D') {moveX += speed;}
    else if (key == 'a' || key == 'A') {moveX -= speed;}
    else if (key == 'w' || key == 'W') {moveY -= speed;}
    else if (key == 's' || key == 'S') {moveY += speed;}

    for (Rectangle r : rectList) {
      if (red.Collision(r.x, r.y, r.w, r.h, moveX, moveY)) {
        // If a collision is detected, we exit this function so there will be no move
        return;
      }      
    }

    red.Move(moveX, moveY);
  }
}

// INTERSECT RECTs
// The old function was nice, but it was really useful only with your specific example. You can re-use this one with any set of rectangles.
// There are many ways to write this function. I wrote this instance back when I was a student, and I still use it to this day.
boolean Intersect(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2)
{
  boolean checkX = false;
  boolean checkY = false;

  if ( (x1<=x2 && (x1+w1)>=x2) || (x1<=(x2+w2) && (x1+w1)>=x2+w2) || (x1>=x2 && (x1+w1)<=(x2+w2)) ) {checkX = true;}
  if ( (y1<=y2 && (y1+h1)>=y2) || (y1<=(y2+h2) && (y1+h1)>=y2+h2) || (y1>=y2 && (y1+h1)<=(y2+h2)) ) {checkY = true;}

  if (checkX && checkY) {return true;}

  return false;
}