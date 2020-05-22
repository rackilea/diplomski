import java.util.*;

public class btest{

  public static boolean TestAnd(int a, int b) {
    for (int i = 0, i < 32, i++) {
      int aBit = (a >> i) & 1;
      int bBit = (b >> i) & 1;
      if (aBit == 1 && bBit == 1) {
        System.out.println("they have  bit 1   in common at position:" + i);
        return false;
      }
    }
    System.out.println("  a & b  is equal :" + (a & b));
    return true;
  }

  public static void main(String[] args) {
    Scanner scnr=new Scanner(System.in);
    int a = scnr.nextInt();
    int b = scnr.nextInt();
    System.out.println(TestAnd(a, b));
  }

}