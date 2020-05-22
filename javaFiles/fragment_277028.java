public class Main<T> {
    static final class Entry {
        T t;           // ERROR: Cannot make a static reference to the non-static type T            
        void f(T t) {} // ERROR: Cannot make a static reference to the non-static type T
    }
}