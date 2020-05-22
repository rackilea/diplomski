public class LongConversion {
  public static void main(String args[]) {
    for (int i = -1; i > -40; i -= 9) {
      // THIS IS THE IMPORTANT LINE, THE REST IS JUST FOR DEMONSTRATION
      long l = 0x00000000FFFFFFFFl & (long) i;

      System.out.println("Original i: " + i);
      System.out.println(Integer.toHexString(i));
      System.out.println("Longed i: " + l);
      System.out.println(zeroLong(l));
      System.out.println();
    }
  }

  public static String zeroLong(long l) {
    return String.format("%16s", Long.toHexString(l)).replace(' ', '0');
  }
}