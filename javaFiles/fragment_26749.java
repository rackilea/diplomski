private static double yIncrement;

public static void cantor(int n, double x0, double x1, double y) {
  if (n == 0)
    return;

  StdDraw.line(x0, y, x1, y);

  y = y - yIncrement;

  double third = (x1 - x0) / 3;
  cantor(n - 1, x0, x0 + third, y); // left
  cantor(n - 1, x1 - third, x1, y); // right

}

public static void main(String[] args) {
  //change n into integer (depth)
  int n = Integer.parseInt(args[0]);

  // specify inital values for line
  double x0 = 0;
  double x1 = 1;
  double y = 1;

  yIncrement = 1.0 / n;
  StdDraw.setPenColor(Color.BLUE);

  // recursive function cantor
  cantor(n, x0, x1, y);
}