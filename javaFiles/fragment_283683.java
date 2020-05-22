abstract class A {
    public static A getInstance() {
          return new B();
    }
}

class B extends A {
}