class A {

    public void f() {
        B b = newB();
        C c = newC();
    }

    protected B newB() {
        return new B();
    }

    protected C newC() {
        return newC();
    }
}