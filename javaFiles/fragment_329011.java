public class TheGeneric<T,V> {
    public TheGeneric(T t, Function<T,V> method) {
        V value=method.apply(t);
        // Do something ...
    }
}