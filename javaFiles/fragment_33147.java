public class MyStream<T> implements Stream<T> {
    private final Stream<T> original;

    public MyStream(Stream<T> original){
        this.original = original;
    }

    // here your own method
    public <V> MyStream<V> call(Function<? super Stream<T>, ? extends Stream<V>> mapper){
        return new MyStream<>(mapper.apply(this));
    }

    // override/implement every method like the following
    @Override
    public MyStream<T> filter(Predicate<T> predicate){
         return new MyStream<>(stream.filter(predicate));
    }

    ...
}