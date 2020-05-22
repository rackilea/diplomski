abstract class A {
  public abstract A create();
}

class B extends A {
  @Override public B create() {
    return new B...
  }
}