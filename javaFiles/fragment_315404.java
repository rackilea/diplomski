public class A {
    public void doSomething() {
        System.out.println("A.doSomething " + this.getClass().getName());
    }
}

public class B extends A {
    public void doSomething() {
        System.out.println("B.doSomething " + this.getClass().getName());
    }
}

public class Test {
    public static native jniTest(B b);
    public static void main(String[] args) {
        B obj = new B();
        jniTest(obj);
    }
}