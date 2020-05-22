@SuppressWarnings("unchecked")
static <T> Iterator<T> mapTraversalIterator(Map<Integer, T> map) {
  return flatten(map(map.values().iterator(), new Function<T, Iterator<T>>() {
      public Iterator<T> apply(T value) {
        if(value instanceof Map) {
          return mapTraversalIterator((Map<Integer, T>)value);
        } else {
          return Collections.singleton(value).iterator();
        }
      }
  }));
}

interface Function<A, B> {
  B apply(A a);
}

static <A, B> Iterator<B> map(Iterator<A> iter, Function<A, B> op) {
  return new Iterator<B>() {
    public boolean hasNext() {
      return iter.hasNext();
    }
    public B next() {
      return op.apply(iter.next());
    }
  };
}

static <A> Iterator<A> flatten(Iterator<Iterator<A>> iter) {
  return new Iterator<A>() {
    private Iterator<A> next = null;

    public boolean hasNext() {
      while(iter.hasNext() && (next == null || !next.hasNext())) {
        next = iter.next();
      }
      if(next == null || !next.hasNext()) return false;
      else return true;
    }
    public A next() {
      if(!hasNext()) throw new NoSuchElementException();
      return next.next();
    }
  };
}