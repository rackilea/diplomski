class Triangle implements Side {
    private Point a, b, c;

    // getters for a, b, c...

    public Point[] getEndPoints() { return new Point[] {a, b, c}; }
}

class Parallelogram implements Side {
    private Point a, b, c, d;

    // getters for a, b, c, d...

    public Point[] getEndPoints() { return new Point[] {a, b, c, d}; }
}