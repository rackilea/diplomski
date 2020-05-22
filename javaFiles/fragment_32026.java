public Point getClosestPoint(List<Point> pts) {
    double minDistSoFar = Double.MAX_VALUE;
    Point rval = null;

    for (Point p : pts) {
        if (p.x == this.x && p.y == this.y) {
            continue;
        }

        double pDist = this.distance(p);
        if (pDist < minDistSoFar) {
            minDistSoFar = pDist;
            rval = p;
        }
    }
}