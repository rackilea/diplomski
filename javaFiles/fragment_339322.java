package b;
import a.A;
public class B extends A {
    @Override public void method2() {
        super.method2();
        System.out.println("B2");
    }
    void method1() {
        System.out.println("B1");
    }
}