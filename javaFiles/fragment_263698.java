public class MyClass {
    int x = 3;

    public void method1() {
        int a = 1;
    }

    public void method2() {
        System.out.println(a); //will not work - a is not in scope
        System.out.println(x); //will work - x is accessible from all methods
    }
}