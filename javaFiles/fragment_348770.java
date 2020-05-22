class A {
  public static final String FOO = "foo";

  static {
    System.out.println("initializing A");
  }
}

class B {
  public static void main(String[] args) {
    System.out.println(A.FOO);
  }
}