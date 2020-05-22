public static boolean intersectCir(int x1, int y1, int rad1, int x2, int y2, int rad2) {
    //distance formula, applied:
    //    ((x1-x2)^2+(y1-y2)^2)^0.5 <= rad1+rad2
    final int xdiff = x1 - x2;
    final int ydiff = y1 - y2;
    final int totalRad = rad1 + rad2;
    //    ((xdiff)^2+(ydiff)^2)^0.5 <= totalRad
    final int distanceSquared = xdiff * xdiff + ydiff * ydiff;//beware overflow!
    //    (distanceSquared)^0.5 <= totalRad
    //square roots are hard, better to just square both sides:
    //    distanceSquared <= totalRad^2
    return distanceSquared <= totalRad * totalRad;
  }