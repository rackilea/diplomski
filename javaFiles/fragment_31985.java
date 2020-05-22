// Convenience method to draw from center with radius
/**
 * 
 * @param cg
 * @param xCenter
 * @param yCenter
 * @param r
 */
public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
    Graphics2D cg2 = (Graphics2D) cg.create();
    System.out.println("Center at: " + (xCenter - r) + "," + (yCenter - r));
    cg2.drawOval(xCenter - r, yCenter - r, 2 * r, 2 * r);

}// end drawCircle