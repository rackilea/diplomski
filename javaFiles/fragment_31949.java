public class Test {
    public static void main(String... args){
        new D().m(new A());
        new D().m(new B());
    }
}

interface I {  }

class A extends java.awt.Component implements I {}
class B extends java.awt.Component implements I {}

class D {
  Component c;
  I i;
  <T extends java.awt.Component & I> void m(T x) {
    c = x;
    i = x;
  }
}