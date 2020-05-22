public abstract class Foo {

    private Foo() {}

    public static Bar createBar() {
        return new BarImpl();
    }

}

public interface Bar {}

Bar myBar = Foo.createBar();