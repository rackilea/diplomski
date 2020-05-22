public class A {

    private B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }

    public void doSomeWork() {
        // WORK
    }

    public void doSomeWorkWithB() {
        b.doSomeWork();
    }
}

public class B {

    private A a;

    @Autowired
    public B(A a) {
        this.a = a;
    }

    public void doSomeWork() {
        // WORK
    }

    public void doSomeWorkWithA() {
        a.doSomeWork();
    }

}