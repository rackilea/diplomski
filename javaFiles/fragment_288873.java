class Bar<T> {
    private Foo<? extends T> var1;
    private Foo<? extends T> var2;

    public Bar(Foo<? extends T> var1, Foo<? extends T> var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public static void main(String[] args) {
        Foo<String> var1 = new Foo<>();
        Foo<Integer> var2 = new Foo<>();
        Bar<Object> b = new Bar<>(var1, var2); // this does now work
    }
}