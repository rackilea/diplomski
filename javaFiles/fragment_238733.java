class Foo<T> {
    void foo(int i) {
        System.out.println("foo(int)");
    }
    void foo(T t) {
        System.out.println("foo(T)");
    }
}

private void test() {
    Foo<Integer> foo = new Foo<>();
    foo.foo(1);
    foo.foo((Integer)1);
    foo.foo(Integer.valueOf("1"));
}