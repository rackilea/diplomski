public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point[] objectPoints = new Point[3];
        double x[] = {3,4,5};
        double y[] = {4,5,6};

        for (int i = 0; i < objectPoints.length; i++) {
            objectPoints[i] = new Point(x[i], y[i]);
        }
    }

}