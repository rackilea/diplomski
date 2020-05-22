class A<T> {
    class C {}
    C c = new C();
    void foo(List<A<?>.C> list) {
        list.add(new A<String>().c);
        list.add(new A<Number>().c);
    }
}