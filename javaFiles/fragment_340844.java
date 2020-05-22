public class B {
    static {
        A.register("Foo", new Factory() {
            public Object create() {
                return new B();
            }
        });
    }

    public void static noOp() {}

    public B() {
        // Create a new instance of class B
    }
}

...

B.noOp();