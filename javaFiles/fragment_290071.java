float c=Math.cos(-rotation);
float s=Math.sin(-rotation);
int x0=Main.width/2;
int y0=Main.height/2;
int x1=      width/2;
int y1=      height/2;
for (int a=0,y=0; y < Main.height; y++)
 for (int     x=0; x < Main.width; x++,a++)
  {
  // coordinate inside dst image rotation center biased
  int xp=x-x0;
  int yp=y-y0;
  // rotate inverse
  int xx=int(float(float(xp)*c-float(yp)*s));
  int yy=int(float(float(xp)*s+float(yp)*c));
  // coordinate inside src image
  xp=xx+x1;
  yp=yy+y1;
  if ((xp>=0)&&(xp<width)&&(yp>=0)&&(yp<height))
       Main.pixels[a]=pixels[xp + yp*width]; // copy pixel
  else Main.pixels[a]=0; // out of src range pixel is black
  }