public class TheGeneric<T> {
    public TheGeneric(T t, ToIntFunction<T> method) {
        int value=method.applyAsInt(t);
        // Do something ...
    }
}