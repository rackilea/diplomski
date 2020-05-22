public static void main(String... args) {
    List<Foo> foos = new ArrayList<Foo>();
    // TODO populate with various foos
    for (Foo foo: foos) {
        if (foo.hasFoo()) {
            // TODO something
            break;
        }
    }
}
static class Foo {
    boolean foo;
    public Foo(boolean value) {
        foo = value;
    }
    public boolean hasFoo() {
        return foo;
    }
}