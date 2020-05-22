class Point
{
  int x, y;
  static Point getPoint(int x, int y)
    { Point this = allocateMemory(Point); this.x = x; this.y = y; }
  static void move(Point this, int a, int b) { this.x = a; this.y = b; }
}
Point p = Point.getPoint(3,4);
Point.move(p, 1, 2);