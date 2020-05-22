private processSequence = 0;
public void modifyPoint(Point p, int factor) {
  // do the stuff you need to do with x and y
  switch (processSequence) {
     case 0: p.x+= factor; break;
     case 1: p.y+=factor; break;
     ... etc
  }
  processSequence++;
  processSequence = processSequence % 4; 
}


...
while (true) {
  modifyPoint(p,factor);
  checkColor(p);
}