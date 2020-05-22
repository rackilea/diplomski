public class Binomial {

  public static long n_choose_r(int n, int r) {
    r = Math.min(r, n - r);
    long [] a = new long[r + 1];
    a[0] = 1;
    for (int i = 1; i <= n; ++i) {
      if (i <= r) {
        a[i] = 1;
      }
      for (int j = Math.min(r, i - 1); j > 0; --j) {
        a[j] += a[j - 1];
      }
    }
    return a[r];
  }

  public static void main(String [] args) {
    System.out.println(n_choose_r(6, 4));
  }
}