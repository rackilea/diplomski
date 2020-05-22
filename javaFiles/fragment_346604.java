package test;

interface I {
  void foo();
}
public class Main implements I {
    public static void main(String[] args) {
        new Main().foo();
    }

    @Override
    public void foo() {
        System.out.println("foo");
    }
}