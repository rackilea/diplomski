public class A {
    public void method1(String s1, int s2) { ... }
}

public class B extends A {
    @Override
    public void method1(String s1, int s2) { ... }
}

A object = new B();
object.method1("xxx",2);