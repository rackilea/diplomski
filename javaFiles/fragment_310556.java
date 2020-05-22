class BFactory {

    public B newInstance() {
        return new B();
    }
}

class CFactory {

    public C newInstance() {
        return new C();
    }
}

class A {

    private final BFactory bFactory;
    private final CFactory cFactory;

    public A(final BFactory bFactory, final CFactory cFactory) {
        this.bFactory = bFactory;
        this.cFactory = cFactory;
    }

    public void f() {
        B b = bFactory.newInstance();
        C c = cFactory.newInstance();
    }
}