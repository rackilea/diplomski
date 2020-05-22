public class IntegerOverflow {
  public static void main(String[] args) {
    int x = 11;

    int i = 0;
    for (i = 0; i <= 5; i++)
    {
      x *= x;
      System.out.format("%-12d\t%s%n", x, Integer.toBinaryString(x));
    }
  }
}