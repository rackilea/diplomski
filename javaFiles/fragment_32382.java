public class Class {
  public static String intToBinary(final int input) {
    int count = (int) Math.ceil(Math.log(input) / Math.log(2));
    int remaining = input;
    final StringBuilder output = new StringBuilder();
    while (count >= 0) {
      final int powerOf2 = (int) Math.pow(2, count);
      if (remaining < powerOf2) {
        output.append("0");
      } else {
        output.append("1");
        remaining -= powerOf2;
      }
      count--;
    }
    return output.toString();
  }

  public static void main(String... args) {
    System.out.println(intToBinary(7));
    System.out.println(intToBinary(8));
    System.out.println(intToBinary(100));
    System.out.println(intToBinary(1234567890));
  }
}