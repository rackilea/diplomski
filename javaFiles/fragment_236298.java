double dist = 0;
double d1 = 10;
int curri = 0; 
int i = 1; 
int maxSquareHeight = 40;
double angle = Math.atan(maxSquareHeight/distToDest);
while (true)
{ 
  curri = i; 
  g.setColor(Color.GREEN); 

  dist = getSquareDistance(d1, scalingFactor, i); 
  if (dist > distToDest) {
    break;
  }
  double sqh = getSquareHeight(dist, angle); 
  g.drawLine(30 + (int)(shipWrap - dist), offset+50-(int)(sqh / 2d), 30 + (int)(shipWrap - dist), offset+50+(int)(sqh / 2d)); 
  g.setColor(Color.LIGHT_GRAY); 
  i++; 
}

public double getSquareHeight(double distance, double angle) { 
  return distance * Math.tan(angle); 
}