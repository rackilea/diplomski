public class Bind {
    public static <A, B> Consumer<A> bindLast(BiConsumer<A, B> fn, B b) {
        return a -> fn.accept(a, b);
    }

    public static <A, B> Consumer<B> bindFirst(BiConsumer<A, B> fn, A a) {
        return b -> fn.accept(a, b);
    }
}