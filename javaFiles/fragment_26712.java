interface Foo {
    <F extends Foo> F bar();

    public static void main(String[] args) {
        Foo foo = null;
        String baz = foo.bar();
    }
}