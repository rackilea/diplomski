public class Constants {

  public static XXX KEY1    = Constants1.KEY1;
  public static XXX KEY2    = Constants1.KEY2;
  public static XXX KEY3    = Constants1.KEY3;

  // ...
  public static XXX KEY2000 = Constants2.KEY2000;

  // Nested class holding 1000 constants
  private static class Constants1 extends SomeBaseClass {
    KEY1 = init(...);
    KEY2 = init(...);
    KEY3 = init(...);
    // ...
  }

  // Nested class holding the next 1000 constants
  private static class Constants2 extends SomeBaseClass {
    // ...
    KEY2000 = init(...);
  }

  // Keep generating nested classes for more constants...
  private static class Constants3 ... {}
}