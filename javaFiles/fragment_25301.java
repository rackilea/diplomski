private static Point checkLineLeft(Point point, Mat intensive) {
  int minX = point.getX() - intensive.width()*0.2;
  int y = point.getY();
  for (int x = point.getX() - 1 ; x > minX && x >= 0 ; x--) {
    if (isCorrectPoint(intensive, x, y)) {
      return new Point(x, y);
    }
  }
  return new Point(-1, -1);
}

private static boolean isCorrectPoint(Mat intensive, int x, int y) {
  return intensity.get(y, x)[0] > 100
      && intensity.get(y, x)[2] < 50;
}