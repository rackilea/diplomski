private static <T> Stream<T> iterate(T root, UnaryOperator<T> generator, Predicate<T> stop) {
  return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<T>() {
    private T t = root;

    @Override
    public boolean hasNext() {
      return stop.test(t);
    }

    @Override
    public T next() {
      T result = t;
      t = generator.apply(t);
      return result;
    }
  }, Spliterator.IMMUTABLE | Spliterator.ORDERED), false);
}