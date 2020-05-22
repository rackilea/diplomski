class A<T> {
    void m(T t) {}
}
class B<T> extends A<T> {
    void m(Object o) {}
}