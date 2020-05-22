private Point2D getPoint(double angle, int directionMuliplier) {
    double l = angle*4;
    double x = directionMuliplier * Math.sin(angle)*l;
    double y = directionMuliplier * Math.cos(angle)*l;
    return new Point2D.Double(x, y);
}