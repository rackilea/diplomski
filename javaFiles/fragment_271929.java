Line2D myLine = getMyLine() // some imagine method giving your line
Point2D[] polyPoints = getPolyPoints() // some imagine method giving point of your Polygon

boolean intersect = false;
for (int i = 0; i < polyPoints.length - 1; i++) {
   intersect = myLine.intersectsLine(polyPoints[i].getX(), polyPoints[i].getY(), polyPoints[i+1].getX(), polyPoints[i+1].getY());
   if (intersect) {
      break;
   }
}
if (!intersect) {
   intersect = myLine.intersectsLine(polyPoints[polyPoints.length - 1].getX(), polyPoints[polyPoints.length - 1].getY(), polyPoints[0].getX(), polyPoints[0].getY());
}