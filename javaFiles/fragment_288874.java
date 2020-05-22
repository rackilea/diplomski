class Bar<T> {
    private Foo<? super T> var1;
    private Foo<? super T> var2;

    public Bar(Foo<? super T> var1, Foo<? super T> var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public static void main(String[] args) {
        Foo<Integer> var1 = new Foo<>();
        Foo<Number> var2 = new Foo<>();
        Bar<Integer> b = new Bar<>(var1, var2); // this does now work
    }
}