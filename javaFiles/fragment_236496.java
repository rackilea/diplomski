public class Point {
    private final x;
    private final y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static boolean isPoint(Object o) {
        return o != null && o instanceof Point;
    }

    private boolean coordsEqual(Point p) {
        return getX() == p.getX() && getY() == p.getY();
    }

    public boolean equals(Object o) {
        return isPoint(o) && coordsEqual((Point) o); //is o is a point? Does it have equal coords?
    }