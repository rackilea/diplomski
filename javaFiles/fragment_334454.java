static class Stream2<T> {

    @SafeVarargs
    @SuppressWarnings("varargs") // Creating a stream from an array is safe
    public static<T> Stream2<T> of(T... values) {
        return new Stream2<>();
    }

     public  <R> R collect(  Supplier<R> supplier,
             BiConsumer<R, ? super T> accumulator,
             BiConsumer<R, R> combiner){return null;}

}