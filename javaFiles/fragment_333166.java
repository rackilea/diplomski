class C {

    // ...

    public A asAObject() {
        return new A() {
            @Override
            void doAStuff() {
                C.this.doAStuff();
            }
        };
    }

    public B asBObject() {
        return new B() {
            @Override
            void doBStuff() {
                C.this.doBStuff();
            }
        };
    }
}