final Iterable<A> iofA ... ;
Iterable<B> iofB = new Iterable<B>() {
  public Iterator<B> iterator() {
    return new Iterator<B>() {
      private final Iterator<A> _iter = iofA.iterator();
      public boolean hasNext() { return _iter.hasNext(); }
      public B next() { return _iter.next().getB(); }
    };
  }
};