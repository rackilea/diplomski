static class Triangle {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double aAngle() {
        return Math.acos(-(Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2)) / (2 * b * c));
    }

    public Point[] triangle() {

        double angle = aAngle();

        Point[] p = new Point[3];

        p[0] = new Point(0, 0);
        p[1] = new Point((int) b, 0);
        p[2] = new Point((int) (Math.cos(angle) * c), (int) (Math.sin(angle) * c));

        Point center = new Point((p[0].x + p[1].x + p[2].x) / 3, 
                                 (p[0].y + p[1].y + p[2].y) / 3);

        for (Point a : p)
            a.translate(-center.x, -center.y);

        return p;
    }
}