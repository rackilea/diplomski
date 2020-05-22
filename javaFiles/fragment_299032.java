public class Test {
  static void separate() {
    String x = "hello";
    String y = x.toString();
    foo(y);
  }

  static void combined() {
    String x = "hello";
    foo(x.toString());
  }

  static void foo(String x) {
  }
}