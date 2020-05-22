class Parent {
  private final Frobnitz foo;

  Parent() throws Exception {
    foo = new Frobnitz();
  }

  void doSomething() {
    foo.doYourFrobbing();
  }
}

class Child extends Parent { ... }

class Main {
  public static void main(String[] args) {
    new Child().doSomething();  // Would cause a NPE unless Parent() is called (implicitly or explicitly).
  }
}