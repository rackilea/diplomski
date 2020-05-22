public static <E> SetView<E> intersection( final Set<E> set1, final Set<?> set2) {
//...
  return new SetView<E>() {
    @Override public Iterator<E> iterator() {
      return Iterators.filter(set1.iterator(), inSet2);
    }
    @Override public int size() {
      return Iterators.size(iterator());
    }
    //...
  };
}