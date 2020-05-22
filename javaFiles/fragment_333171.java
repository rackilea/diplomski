interface Foo<T> { /* ... */ }

class Bar {
    public void do_(Foo<Integer> obj) { }
    public <A extends Object & Foo<Double>> void do_(A obj) { }
}