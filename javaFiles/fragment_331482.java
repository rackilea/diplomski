import java.util.Arrays;
import java.util.Random;

public class Test {
  public static void main(String[] args) {
    Random rand = new Random(3);
    System.out.println(Arrays.toString(logRandom(rand, 0.001, 1000, 7)));
    System.out.println(Arrays.toString(logRandom(rand, 0.001, 1000, 7)));
    System.out.println(Arrays.toString(logRandom(rand, 0.001, 1000, 7)));
    System.out.println(Arrays.toString(logRandom(rand, 0.001, 1000, 7)));
  }

  public static double[] logRandom(Random rand, double lowerLimit,
      double upperLimit, int count) {
    double[] result = new double[count];
    double logLower = Math.log(lowerLimit);
    double logUpper = Math.log(upperLimit);
    for (int i = 0; i < count; i++) {
      double raw = rand.nextDouble();
      result[i] = Math.exp(raw * (logUpper - logLower) + logLower);
      if (result[i] < lowerLimit) {
        result[i] = lowerLimit;
      } else if (result[i] > upperLimit) {
        result[i] = upperLimit;
      }
    }
    Arrays.sort(result);
    return result;
  }

}