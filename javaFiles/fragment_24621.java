PImage sand;
PImage fossil;

void setup()
{
  size(400, 400);
  fossil = loadImage("CellNoise.jpg");
  sand = loadImage("CellVoronoi.jpg");
}

void draw()
{
  //tint from 255 to 0 for the top image
  tint(255,map(mouseX,0,width,255,0));
  image(fossil, 0, 0, width, height);
  //tint from 0 to 255 for the bottom image - 'cross fade'
  tint(255,map(mouseX,0,width,0,255));
  image(sand, 0, 0, width, height);
}