public class MyClass {
    private A a;

    public MyClass(A a) {
        this.a = a;
    }

    public void someMethod() {
        a.setVar1(20);
        a.someMethod();
    }
}