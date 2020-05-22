PGraphics mask, filler;
int x;

void setup(){
  size(400,400);

  // initial bg color, the white circle...
  background(255);

  //init both PGraphics
  mask = createGraphics(width, height);
  filler = createGraphics(width, height);

  // draw a circle as a mask
  mask.beginDraw();
  mask.background(255);
  mask.noStroke();
  mask.fill(0);
  mask.ellipse(width/2, height/2, 200, 200);
  mask.endDraw();
}

void draw(){

  // a changing bg 
  x = (x+1)%255;
  background(x);

  //dinamiaclly draw random rects
  filler.beginDraw();
  filler.noStroke();
  filler.fill(random(255), random(255), random(255));
  filler.rect(random(width), random(height), random(5,40), random(5,40));
  filler.endDraw();

  // get an imge out ofthis...
  PImage temp = filler.get();

  //mask image
  temp.mask(mask);

  //dispay it
  image(temp, 0, 0);
}

void mousePressed(){

  mask.beginDraw();
  mask.background(0);
  mask.noStroke();
  mask.fill(255);
  mask.ellipse(width/2, height/2, 200, 200);
  mask.endDraw();
}

void mouseReleased(){

  mask.beginDraw();
  mask.background(255);
  mask.noStroke();
  mask.fill(0);
  mask.ellipse(width/2, height/2, 200, 200);
  mask.endDraw();
}