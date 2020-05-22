public class Euler2Correct {
  public static int Fibonacci(int j) {
    int tmp;
    int a = 2;
    int b = 1;
    int total = 0;

    do {
      if(isEven(a)) total +=a;
      tmp = a + b;
      b = a;
      a = tmp;      
    } while (a < j);

    return total;

  }

  private static boolean isEven(int a) {
    return (a & 1) == 0;
  }

  public static void main(String[] args) {
    // Notice there is no more loop here
    System.out.println(Fibonacci(4_000_000));
  }
}