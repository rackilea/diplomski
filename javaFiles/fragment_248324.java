private static void banachCurve(final double x, final double y, final double r, final int n) {
    if (n == 0) {
        return;
    }
    final double d = r / 3;
    StdDraw.circle (x, y, d);
    banachCurve (x, y, d, n - 1);     // centre
    banachCurve (x, y + d, d, n - 1); // north
    banachCurve (x + d, y, d, n - 1); // east
    banachCurve (x, y - d, d, n - 1); // south
    banachCurve (x - d, y, d, n - 1); // west
    // Get the diagonal radius for a point at 45 degrees on the circle
    final double diagD = Math.cos(Math.toRadians(45)) * d;
    banachCurve (x + diagD, y + diagD, d, n - 1); // north-east
    banachCurve (x + diagD, y - diagD, d, n - 1); // south-east
    banachCurve (x - diagD, y - diagD, d, n - 1); // south-west
    banachCurve (x - diagD, y + diagD, d, n - 1); // north-west
}