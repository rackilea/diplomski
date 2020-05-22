private static double yIncrement;

public static void cantor(int n, double x0, double x1, double y) {
  if (n == 0)
    return;

  x0 = Math.ceil(x0);
  x1 = Math.floor(x1);

  StdDraw.line(x0, y, x1, y);

  y = y - yIncrement;

  double third = (x1 - x0) / 3;
  cantor(n - 1, x0, x0 + third, y); // left
  cantor(n - 1, x1 - third, x1, y); // right

}

public static void main(String[] args) {
  // change n into integer (depth)
  int n = Integer.parseInt(args[0]);

  int width = 1920;
  int height = 1080;

  StdDraw.setCanvasSize(width, height);

  // specify inital values for line
  double x0 = 0;
  double x1 = width;
  double y = 1;

  yIncrement = 1.0 / n;
  StdDraw.setPenColor(Color.BLUE);
  StdDraw.setXscale(0, width);

  // recursive function cantor
  cantor(n, x0, x1, y);
}