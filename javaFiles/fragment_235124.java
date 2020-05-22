public class A {
    private B b;
    public A(B b) { // Spring will autowired by magic when calling the constructor
        this.b = b;
    }
    public void doSomething() {
        b.doSomeThingElse();
    }
}

@Component
public class B {
    private C c;
    public B(C c) {
        this.c = c;
    }
    public void doSomethingElse(){
        c.doIt();
    }
}