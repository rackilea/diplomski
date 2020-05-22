public class MyClass {

  public interface A {
    void foo();
  }

  public interface B {
    void bar();
  }

  public interface C extends A, B {
    void baz();
  }

  public void doIt(C c) {
    c.foo();
    c.bar();
    c.baz();
  }

  public static void main(String[] args) {
    MyClass mc = new MyClass();

    mc.doIt(new C() {
      @Override
      public void foo() {
        System.out.println("foo()");
      }

      @Override
      public void bar() {
        System.out.println("bar()");
      }

      @Override
      public void baz() {
        System.out.println("baz()");
      }
    });
  }

}