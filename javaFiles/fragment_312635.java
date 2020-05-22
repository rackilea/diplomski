public final class Foo implements Cloneable {
    private final int bar;

    public Foo(int bar) {
        this.bar = bar;
    }

    @Override
    public Object clone() {
        return new Foo(bar);
    }
}