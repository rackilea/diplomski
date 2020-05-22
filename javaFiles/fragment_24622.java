PImage sand,fossil;
int side = 40;//size of square 'brush'
void setup()
{
  size(400, 400);
  fossil = loadImage("CellNoise.jpg");
  sand = loadImage("CellVoronoi.jpg");
}
void draw()
{
  image(fossil, 0, 0, 400, 400);
  if(mousePressed) {
    for(int y = 0 ; y < side ; y++){
       for(int x = 0; x < side; x++){
        //copy pixel from 'bottom' image to the top one
        //map sketch dimensions to sand/fossil an dimensions to copy from/to right coords
        int srcX = (int)map(mouseX+x,0,width+side,0,sand.width);
        int srcY = (int)map(mouseY+y,0,height+side,0,sand.height);
        int dstX = (int)map(mouseX+x,0,width+side,0,fossil.width);
        int dstY = (int)map(mouseY+y,0,height+side,0,fossil.height);
        fossil.set(dstX, dstY, sand.get(srcX,srcY));
       }
     }
  }
}