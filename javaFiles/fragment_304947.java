Class A {
    private A() {
        //Do something
    }
    public static A newA() {
        A a = new A();
        a.afterCreate();
        return a;
    }
}

Class B extends A {
    private B() {
        super();
    }
    public static B newB() {
        B b = new B();
        b.afterCreate();
        return b;
    }
}

Class C extends B {
    private C() {
        super();
        //Do something
    }
    public static C newC() {
        C c = new C();
        c.afterCreate();
        return c;
    }
}