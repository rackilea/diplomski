public class Main {

    public static Point[] getP3(Point p1, double distanceFromP1, Point p2, double distanceFromP2) {
        double d = p1.distance(p2);

        if(d > (distanceFromP1 + distanceFromP2) || p1.equals(p2) || d < Math.abs(distanceFromP1 - distanceFromP2)) {
            // there does not exist a 3rd point, or there are an infinite amount of them
            return new Point[]{};
        }

        double a = (distanceFromP1*distanceFromP1 - distanceFromP2*distanceFromP2 + d*d) / (2*d);
        double h = Math.sqrt(distanceFromP1*distanceFromP1 - a*a);

        Point temp = new Point(p1.x + a*(p2.x - p1.x) / d, p1.y + a*(p2.y - p1.y) / d);

        return new Point[]{
                new Point(temp.x + h * (p2.y - p1.y) / d, temp.y - h * (p2.x - p1.x) / d),
                new Point(temp.x - h * (p2.y - p1.y) / d, temp.y + h * (p2.x - p1.x) / d)
        };
    }

    public static void main(String[]args) throws Exception {
        Point a = new Point(1,1);
        Point b = new Point(5,4);
        Point c = new Point(0,0);
        Point d = new Point(2,0);
        System.out.println("test 1 :: "+Arrays.toString(getP3(a, 4, b, 3)));       // 2 distinct 3rd points
        System.out.println("test 2 :: "+Arrays.toString(getP3(c, 1, d, 1)));       // 1 distinct 3rd point
        System.out.println("test 3 :: "+Arrays.toString(getP3(c, 0.99999, d, 1))); // none
        System.out.println("test 4 :: "+Arrays.toString(getP3(d, 1, d, 1)));       // infinite
        System.out.println("test 5 :: "+Arrays.toString(getP3(c, 50, d, 1)));      // none, one circle "contains" the other
    }
}

class Point {

    final double x;
    final double y;
    private final int hash;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.hash = Double.valueOf(x).hashCode() ^ Double.valueOf(y).hashCode();
    }

    public double distance(Point that) {
        double dX = this.x - that.x;
        double dY = this.y - that.y;
        return Math.sqrt(dX*dX + dY*dY);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) return false;
        Point that = (Point)o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return  hash;
    }

    @Override
    public String toString() {
        return String.format("(x=%f, y=%f)", x, y);
    }
}