public class FinallyReturn {
  public static final void main(String[] args) {
    System.out.println(foo(args));
  }

  private static int foo(String[] args) {
    try {
      int n = Integer.parseInt(args[0]);
      return n;
    }
    finally {
      return 42;
    }
  }
}