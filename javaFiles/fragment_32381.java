public class Class {
  private static String intToBinary(final int input, final int count) {
    int powerOf2 = (int) Math.pow(2, count);
    if (count < 0) {
      return "";
    } else if (input < powerOf2) {
      return "0" + intToBinary(input, count - 1);
    } else {
      return "1" + intToBinary(input - powerOf2, count - 1);
    }
  }

  public static String intToBinary(final int input) {
    return intToBinary(input, (int) Math.ceil(Math.log(input) / Math.log(2)));
  }

  public static void main(String... args) {
    System.out.println(intToBinary(7));
    System.out.println(intToBinary(8));
    System.out.println(intToBinary(100));
    System.out.println(intToBinary(1234567890));
  }
}