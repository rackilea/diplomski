Arc2D.Double a=new Arc2D.Double(x+3*w/4-w/16, y+h/4-h/16, 2*w/16, 2*h/16, 270, 250, Arc2D.OPEN);
Arc2D.Double a2=new Arc2D.Double(x+3*w/4, y+h/4, 2*w/16, 2*h/16, 270, 200, Arc2D.OPEN);
Rectangle b=a.getBounds();
int intrsct=0;
for(i=0; i<b.getWidth(); i++)
for(j=0; j<b.getHeight(); j++)
  if(a.contains(b.x+i, b.y+j) && a2.contains(b.x+i, b.y+j)) intrsct++;