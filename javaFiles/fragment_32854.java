public static <T> Runnable bind(T value, Consumer<T> c) {
    return ()->c.accept(value);
}
public static <T,U> Consumer<U> compose(Function<U,T> f, Consumer<? super T> c) {
    return u->c.accept(f.apply(u));
}