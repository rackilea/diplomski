/**
 * Checks if the mouse location is within the circle
 * @param mouseLocation the location of the mouse
 * @param cX circle center X location
 * @param cY circle center Y location
 * @param cR circle radius
 * @return true if the mouse is no more than cR units away from the center of the circle 
 */
private static boolean isInCircle(Point mouseLocation, double cX, double cY, double cR){
    final double dX = mouseLocation.getX()-cX;
    final double dY = mouseLocation.getY()-cY;
    return Math.sqrt(dX*dX+dY*dY)<=cR;
}