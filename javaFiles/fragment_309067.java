public void equals (Object o) {
    if(o instanceof Point) {
        Point p = (Point)o;
        return p.x == x && p.y == y;
    } else {
        return false;
    }
}

public Point getCopy() {
    return new Point(x, y);
}

public double slope(Point otherPoint) {
    return ((double)(otherPoint.y - y)) / ((double)(otherPoint.x / x));
}

public double distance (Point otherPoint) {
    double dx = otherPoint.x - x;
    double dy = otherPoint.y - y;
    return Math.sqrt((dx * dx) + (dy * dy));
}

public double distanceFromOrigin() {
    return distance(new Point(0, 0));
}

public boolean isHorizontal (Point otherPoint) {
    return otherPoint.y == y;
}

public boolean isVertical(Point otherPoint) {
    return otherPoint.x == x;
}

public void transform (double dx, double dy) {
    x += dx;
    y += dy;
}