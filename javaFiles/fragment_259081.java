boolean keyup = false;
boolean keyright = false;
boolean keyleft = false;
boolean keydown = false;

float x,y;

void setup() {
  size(640,360);  
  x = width/2;
  y = height/2;
}

void draw() {
  background(51);
  fill(255);
  ellipse(x,y,16,16);

  if (keyup) y--;
  if (keydown) y++;
  if (keyleft) x--;
  if (keyright) x++;


}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) keyup = true; 
    if (keyCode == DOWN) keydown = true; 
    if (keyCode == LEFT) keyleft = true; 
    if (keyCode == RIGHT) keyright = true; 
  }
}

void keyReleased() {
  if (key == CODED) {
    if (keyCode == UP) keyup = false; 
    if (keyCode == DOWN) keydown = false; 
    if (keyCode == LEFT) keyleft = false; 
    if (keyCode == RIGHT) keyright = false; 
  }
}