Graphics g = Graphics.FromImage(someBitMap); //create a graphics object for an existing BitMap
Color c = new Color(255,0,0); //a "red" color
Pen p = new Pen(c); //create a Pen using the Red color from earlier
p.Width = 5; //Pen is 5 pixels wide

g.DrawLine(p, 0,0,100,100); //draw a diagonal line

//Get rbg values.
int r = c.R;
int g = c.G;
int b = c.B;

//It is VERY important to call `.Dispose()` on GDI objects.  They contain unmanaged system resources that can, and will, leak if you don't.
g.Dispose()
p.Dispose()