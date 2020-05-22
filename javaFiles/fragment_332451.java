public class Line {
    Point p1, p2;
    Line (Point point1, Point point2) {
        this.p1 = point1;
        this.p2 = point2;
    }
    public Point midpoint() {
        return new Point ((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2);
    }
    public double abstand() {
        return Math.sqrt(
            (p1.getX() - p2.getX()) *  (p1.getX() - p2.getX()) + 
            (p1.getY() - p2.getY()) *  (p1.getY() - p2.getY())
        );
    }
    static public void main (String args[]) {
        Line s = new Line (new Point(2.0, 2.0), new Point(5.0, 6.0));
        Point mp = s.midpoint();
        System.out.println ("Midpoint = (" + mp.getX() + "," + mp.getY() + ")");
        double as = s.abstand();
        System.out.println ("Length   = " + as);
    }
}