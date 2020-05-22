class Foo {
    int a;
    int b;
    int c = b;

    int var1;
    int var2;

    public Foo() {
        a = b;

        var1 = var2;
        var2 = var1;
    }
}