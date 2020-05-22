public class A {

    private C c;

    @Autowired
    public A(C c) {
        this.c = c;
    }

    public void doSomeWork() {
        // WORK
    }

    public void doSomeWorkWithC() {
        c.doSomeWorkThatWasOnA();
    }

}

public class B {

    private C c;

    @Autowired
    public B(C c) {
        this.c = c;
    }

    public void doSomeWork() {
        // WORK
    }

    public void doSomeWorkWithC() {
        c.doSomeWorkThatWasOnB();
    }

}

public class C {

    public void doSomeWorkThatWasOnB() {
        // WORK

    }

    public void doSomeWorkThatWasOnA() {
        // WORK
    }

}