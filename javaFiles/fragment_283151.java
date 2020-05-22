public class ArcHitDetector {
    public enum Quadrant {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }
    private int xCenter, yCenter, innerR2, outerR2;
    /**
     * Construct an ArcHitDetector for an annulus centered at given
     * points and with given inner and outer radii.
     *
     * @param xCenter the horizontal center coordinate
     * @param yCenter the vertical center coordinate
     * @param outerR the outer radius of the annulus
     * @param innerR the inner radius of the annulus
     */
    public ArcHitDetector(int xCenter, int yCenter, int outerR, int innerR) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.outerR2 = outerR * outerR;
        this.innerR2 = innerR * innerR;
    }

    /**
     * Classify a point with respect to the annulus. It assumes
     * screen coordinates (x increases to the right; y increases
     * down).
     *
     * @param x the x coordinate of the point to test
     * @param y the y coordinate of the point to test
     *
     * @return the Quadrant of the annulus in which the point falls,
     *    or null if the point does not lie in the annulus
     */
    public Quadrant classifyHit(int x, int y) {
        int dx = x - xCenter;
        int dy = y - yCenter;
        int d2 = dx * dx + dy * dy;
        if (d2 <= outerR2 && d2 >= innerR2) {
            if (x >= xCenter) {
                return y <= yCenter ? TOP_RIGHT : BOTTOM_RIGHT;
            } else {
                return y <= yCenter ? TOP_LEFT : BOTTOM_LEFT;
            }
        } else {
            return null;
        }
    }
}