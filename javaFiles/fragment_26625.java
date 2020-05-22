public class TriangularStars {
  private static final double ERROR = 1e-7;

  public static void main(String args[]) {
    int triangle = 0;
    for (int i = 0; triangle >= 0; i++) {
      triangle = determineTriangleNumber(i, triangle);
      if (isStarNumber(triangle)) {
        System.out.println(triangle);
      }
    }
  }

  public static boolean isStarNumber(int possibleStar) {
    double test = (possibleStar - 1) / 6.;
    int reduce = (int) (test + ERROR);
    if (Math.abs(test - reduce) > ERROR)
      return false;

    int sqrt = (int) (Math.sqrt(reduce) + ERROR);
    return reduce == sqrt * (sqrt + 1);
  }

  public static int determineTriangleNumber(int i, int previous) {
    return previous + i;
  }
}