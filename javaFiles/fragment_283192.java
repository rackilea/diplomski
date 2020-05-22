public class NoBoring {
    public static int noBoringZeros(int n) {
      System.out.println(n);
      System.out.println(Math.abs(n % 10));

        if(Math.abs(n % 10) != 0 || n == 0){
          return n;
        }

      return noBoringZeros(n/10);
    }
}