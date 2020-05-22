529  public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int size) {
530    checkNotNull(iterable);
531    checkArgument(size > 0);
532    return new FluentIterable<List<T>>() {
533      @Override
534      public Iterator<List<T>> iterator() {
535        return Iterators.partition(iterable.iterator(), size);
536      }
537    };
538  }