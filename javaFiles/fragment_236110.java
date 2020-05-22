public class A {
     public class InnerA {
          public void action() { }
     }

     public void addInnerA(InnerA innerA) { }
}

public class B {
     public void transform(A a) {
          a.addInnerA(a.new InnerA() {
              public void action() { }
          });
     }
}