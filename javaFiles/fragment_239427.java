public class Simple extends Base {
    private Simple(TextBox t) {
        super(t);
        // continue doing stuff with t here
    }

    public Simple() {
        this(new TextBox());
    }
}