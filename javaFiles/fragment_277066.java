class A<T> {
    class C {}
    List<C> l1 = null;
    List<A<?>.C> l2 = l1; // Error: incompatible types...
    List<? extends A<?>.C> l3 = l1; // OK
}