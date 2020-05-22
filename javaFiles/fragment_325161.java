public class Stream<T> {
    // private constructor(s)

    public static <T> Stream<T> empty() { /* ... */ }

    public static <T> Stream<T> cons(Supplier<T> head, Supplier<Stream<T> tail) { /* ... */ }

    public static <T> Stream<T> lazy(Supplier<Stream<T>> stream) { /* ... */ }

    public Stream<T> filter(Predicate<T> p) {
        if ( /* this stream is empty */ ) {
            return Stream.empty();
        } else if ( /* head element satisfies predicate */ ) {
            // lazily filter tail, cons head element
        } else {
            return Stream.lazy(() -> this.tail.get().filter(p));
        }
    }
}