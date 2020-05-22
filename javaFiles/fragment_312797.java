private float getMaxDist(Point2D.Float point) {
    float xMax;
    float yMax;
    if (Math.abs(point.x) > Math.abs(point.y)) {
        xMax = Math.signum(point.x);
        yMax = point.y * point.x / xMax;
    } else {
        yMax = Math.signum(point.y);
        xMax = point.x * point.y / yMax;
    }
    Point2D.Float maxPoint = new Point2D.Float(xMax, yMax);
    Point2D.Float center = new Point2D.Float(0, 0);
    return (float) center.distance(maxPoint);
}