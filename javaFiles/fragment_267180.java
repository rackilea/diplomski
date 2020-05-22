public class SingleMult {
  public static void main(String[] args) {
    A a = new B();
    assert(new SingleMult().method(a) == "A");
  }

  String method(A a) { return "A"; }
  String method(B b) { return "B"; }
}

interface A {}

class B implements A {}