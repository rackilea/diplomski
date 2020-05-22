public class Test {
  public static void main(String[] args) {
    System.out.println(roundToPowerOfTwo(0.44, 2));
    System.out.println(roundToPowerOfTwo(0.44, 3));
    System.out.println(roundToPowerOfTwo(0.44, 4));
    System.out.println(roundToPowerOfTwo(0.44, 5));
    System.out.println(roundToPowerOfTwo(0.44, 6));
    System.out.println(roundToPowerOfTwo(0.44, 7));
    System.out.println(roundToPowerOfTwo(0.44, 8));
  }

  public static double roundToPowerOfTwo(double in, int power) {
    double multiplier = 1 << power;
    return Math.rint(in * multiplier) / multiplier;
  }
}