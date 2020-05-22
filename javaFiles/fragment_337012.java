public class IntegerOverflow {
  public static void main(String[] args) {
    int x = 10;

    int i = 0;
    for (i = 0; i <= 5; i++)
    {
      x *= x;
      System.out.println(Integer.toBinaryString(x));
    }
  }
}