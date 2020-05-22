class Point
{
  int x, y;
  Point(int x, int y) { this.x = x; this.y = y; }
  void move(int a, int b) { x = a; y = b; }
}
Point p = new Point(3,4);
p.move(1,2);