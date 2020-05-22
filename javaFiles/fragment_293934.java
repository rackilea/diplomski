final class FooBar {

    final SimpleStringProperty foo;
    final SimpleStringProperty bar;

    FooBar(final String foo, final String bar) {
        this.foo = new SimpleStringProperty(foo);
        this.bar = new SimpleStringProperty(bar);
    }

    @Override
    public String toString() {
        return new StringBuilder("FooBar{")
                .append("foo=").append(foo)
                .append(", bar=").append(bar)
                .append('}')
                .toString();
    }

}