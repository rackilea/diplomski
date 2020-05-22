public static Rectangle createIntersection(Rectangle r1, Rectangle r2) {

     // Left x
     int leftX = Math.max(r1.x, r2.x);

     // Right x
     int rightX = (int) Math.min(r1.getMaxX(), r2.getMaxX());

     // TopY
     int topY = Math.max(r1.y,r2.y);

     // Bottom y
     int botY =  (int) Math.min(r1.getMaxY(), r2.getMaxY());

     if ((rightX > leftX) && (botY > topY)) {
         return new Rectangle(leftX, topY, (rightX - leftX), (botY -topY));
     }

     return null;
 }