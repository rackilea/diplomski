public class Triangle extends Point {
    protected int size;
    private int p1x, p2x, p3x, p1y, p2y, p3y;
    private int xOffset=0;
    private int yOffset=0;

    // ...

    //Draw the triangle with current specifications on screen.
    public void display(Graphics g) {
        p1x = (size / 3) + xOffset;
        p2x = (size / 2) + xOffset;
        p3x = ((2 * size) / 3) + xOffset;
        p1y = ((2 * size) / 3) + yOffset;
        p2y = (size / 3) + yOffset;
        p3y = ((2 * size) / 3) + yOffset;
        int[] xPoints = { p1x, p2x, p3x };
        int[] yPoints = { p1y, p2y, p3y };
        int npoints = 3;
        g.fillPolygon(xPoints, yPoints, npoints);
    }

    public void moveXY(int deltaX, int deltaY) {
        xOffset += deltaX;
        yOffset += deltaY;
    }
}