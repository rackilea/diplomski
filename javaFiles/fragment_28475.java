class Base {
  private final String t;
  private final int length;
  Base(String t) {
    this.t = t;
    length = this.t.length();// here you'll got NullPointerException
  }
}
class Override {
   Override() {
     super(calculate());
   }
   String calculate() {
     return "Override";
   }
}
class OverrideB {
  private final String b = "some string";
  OverrideB() {
  }
  String calculate() {
    return b;
  }
}