class MyCollection<E> {

  private Set<E> underlying = ConcurrentHashMap.newKeySet();

  void add(E elem) {
    underlying.add(elem);
  }

  @Nullable E findAndRemove(Predicate<E> predicate) {
    for (E e : underlying) {
        if (predicate.test(e) && remove(e)) {
          return e;
        }
    }
    return null;
  }   
}