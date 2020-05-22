public class Test
  public Test() {
    // Never called.
    System.out.println("Constructor was called.");
  }

  public static void main(String[] args) {
    Test test = mock(Test.class);
  }