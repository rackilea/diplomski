abstract class A {
    abstract void   put(Object o);
    abstract Object get();
}
class B<T> extends A {
    T t;
    void put(T t) { this.t = t; }
    T    get()    { return t;   }
}