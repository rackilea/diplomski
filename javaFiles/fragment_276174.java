static <T> Spliterator<T> takeWhile(
    Spliterator<T> splitr, Predicate<? super T> predicate) {
  return new Spliterators.AbstractSpliterator<T>(splitr.estimateSize(), 0) {
    boolean stillGoing = true;
    @Override public boolean tryAdvance(Consumer<? super T> consumer) {
      if (stillGoing) {
        boolean hadNext = splitr.tryAdvance(elem -> {
          if (predicate.test(elem)) {
            consumer.accept(elem);
          } else {
            stillGoing = false;
          }
        });
        return hadNext && stillGoing;
      }
      return false;
    }
  };
}

static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<? super T> predicate) {
   return StreamSupport.stream(takeWhile(stream.spliterator(), predicate), false);
}