class BaseClass {
  private void f() { }
}

class DerivedClass {
  public void f() { }
}

class Bystander {
  public static void main() {
    BaseClass inst = new DerivedClass();
    inst.f();
  }
}