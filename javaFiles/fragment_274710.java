public void step( Graphics2d g ) {
    Point midPoint = getMidPoint();
    Point endPoint = getEndPoint();
    drawStep( g, currentPoint, midPoint, endPoint );
    currentPoint = endPoint;
 }

public void drawStep( Graphics2d g, Point first, Point mid, Point last ) {
   g.drawLine( first.x, first.y, mid.x, mid.y );
   g.drawLine( mid.x, mid.y, last.x, last.y );
}

public Point getMidPoint(){
   return new Point( currentPoint.x, currentPoint.y + stepHeight );
}

public Point getEndPoint(){
   return new Point( currentPoint.x + stepWidth, currentPoint.y + stepHeight );
}