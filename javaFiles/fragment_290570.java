public static class AE<T extends A> {
    protected T field;

    public AE(T field) {
        this.field = field;
    }

    public void doStuff() {
        field.doA();
    }

}

public static class BE extends AE<B> {

    // wanna have B field;

    public BE(B field) {
        super(field);
    }

    public void doAnotherStuff() {
        field.doA();
        field.doB();
    }

}