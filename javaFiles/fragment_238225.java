import java.util.Arrays;

public class Ctest {
  public static void main(String[] args) {
    int[] a = new int[] { 1, 4, 7, 1, 7, 4, 1, 5, 5, 8 };
    System.out.println("RES: " + uniquePairs(a));
  }

  public static int uniquePairs(int[] a) {
    Arrays.sort(a);
    // now we have: [1, 1, 1, 4, 4, 5, 5, 7, 7]

    int res = 0;
    int len = a.length;
    int i = 0;

    while (i < len) {
      // take first number
      int num = a[i];
      int c = 1;
      i++;

      // count all duplicates
      while(i < len && a[i] == num) {
        c++;
        i++;
      }
      System.out.println("Number: " + num + "\tCount: "+c);
      // if we spotted number just 2 times, increment result
      if (c == 2) {
        res++;
      }
    }

    return res;
  }
}