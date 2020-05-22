// make sure it is final if you are synchronizing on it
private final int[] a = new int[N];
...

public void m(int i) {
   synchronized (a) {
      a[i]++:
   }
}