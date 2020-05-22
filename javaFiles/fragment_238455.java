abstract class A {
    public void foo() {
        System.out.println("a");
    }
}
interface B {
    default void foo() {
        System.out.println("b");
    }
}
class C extends A implements B {
    public static void main(String[] args) {
        new C().foo();  // prints a
    }
}