public class Test {
  public static void main(String args[]) {
    int[][] input1 = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 0, 0 },
        { 0, 0, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

    testit(input1, 10);

    int[][] input2 = new int[20][20];
    for(int i=5; i<15; i++){
      for(int j = 5; j<15; j++){
        input2[i][j] = 1;
      }
    }

    testit(input2, 45);
    testit(input2, 10);
    testit(input2, 90);
  }

  private static void testit(int[][] input, double degrees) {
    int[][] output = rotate(input, degrees);
    System.out.println("Angle: "+degrees+" degrees");
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        System.out.print(input[i][j]);
      }
      System.out.print(" ");
      for (int j = 0; j < output[i].length; j++) {
        System.out.print(output[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  private static int[][] rotate(int[][] input, double degrees) {

    double rad = Math.toRadians(degrees);
    double sin = Math.sin(-rad);
    double cos = Math.cos(-rad);

    int[][] output = new int[input.length][input[0].length];

    for (int i = 0; i < output.length; i++) {
      double oldX = i - output.length / 2.0; // move to center
      for (int j = 0; j < input[i].length; j++) {
        {
          double oldY = j - output[i].length / 2.0; // move to center
          double x = (int) (cos * oldX + sin * oldY + input.length / 2.0);
          double y = (int) (-sin * oldX + cos * oldY + input[i].length / 2.0);
          output[i][j] = getNearestVal(input, x, y);
        }
      }
    }
    return output;
  }

  private static int getNearestVal(int[][] input, double x, double y) {
    int xLow = (int) Math.floor(x);
    int xHigh = (int) Math.ceil(x);
    int yLow = (int) Math.floor(y);
    int yHigh = (int) Math.ceil(y);
    int[][] points = { { xLow, yLow }, { xLow, yHigh }, { xHigh, yLow },
        { xHigh, yHigh } };
    double minDistance = Double.POSITIVE_INFINITY;
    int minDistanceValue = 0;
    for (int[] point : points) {
      double distance = (point[0] - x) * (point[0] - x) + (point[1] - y)
          * (point[1] - y);
      if (distance < minDistance) {
        minDistance = distance;
        if (point[0] >= 0 && point[0] < input.length && point[1] >= 0
            && point[1] < input[point[0]].length) {
          minDistanceValue = input[point[0]][point[1]];
        } else {
          minDistanceValue = 0;
        }
      }
    }
    return minDistanceValue;
  }
}