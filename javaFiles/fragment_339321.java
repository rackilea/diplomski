package a;
public class A {
    void method1() {
        System.out.println("A1");
    }
    public void method2() {
        method1();
        System.out.println("A2");
    }
}