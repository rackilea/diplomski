int x, y, sz;
float factor = 0.87;//any value here
float transx = 50;//any value here
float transy = 25;//any value here
void setup()
{
  size(400, 400);
  x=100;
  y=100;
  sz=50;
}


void draw()
{

  noFill();
  //draw at original positon, no fill
  rect(x, y, sz, sz);
  scale(factor);
  translate(transx, transy);
  fill(255);
  //draw after scalling and positioning filled this is tested for insidness
  rect(x, y, sz, sz);
  if ( mouseX / factor - transx > x    && 
       mouseX / factor - transx < x+sz && 
       mouseY / factor - transy > y    && 
       mouseY / factor - transy < y+sz)
  {
    println("i'm inside!!!");
  }
  else
  {
    println("i'm outside");
  }