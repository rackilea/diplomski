public class GCD {

private static int callCount = 0;

public static int GCD(int m, int n){
  if (n==0) return m;
  callCount++;
  return GCD(n,m%n);
}


public static void main(String[] args) {
    System.out.println(GCD(10, 15));
    System.out.println(callCount);
}
}