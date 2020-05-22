public class Point {
    private int x;
    private int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
       // Test for null, and type
       ...
       Point p = (Point) obj;
       return x == p.x && y == p.y;
    }