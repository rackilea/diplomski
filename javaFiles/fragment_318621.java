public class Tester {
  public static void main(String[] args) {
    System.out.println(InnerTester.MY_STRING);
  }

  public class InnerTester {
    public static final String MY_STRING = "MY_STRING";
  }
}