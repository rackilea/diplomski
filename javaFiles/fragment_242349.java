import java.util.Random;

class StayInSchool {
  public static void main(String[] args) {
    System.out.println(coinToss(1000000000, 0.75));
  }
  static long coinToss(long iterations, double threshold) {
    double mean = threshold * iterations;
    double stdDev = Math.sqrt(threshold * (1-threshold) * iterations);

    double p = new Random().nextGaussian();
    return (long) (p*stdDev + mean);
  }
}