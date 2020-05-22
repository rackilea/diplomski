// drawing of channel1 data:
iterator it = readingsFromChannel1.iterator();
while(it.next())
{
  Map.Entry m =(Map.Entry)it.next();
  int key=(Integer)m.getKey();
  float value=(float)m.getValue();
  // I assume that you have a putpixel(x,y) method for drawing:
  putPixel(key - eventTimer, value);
}