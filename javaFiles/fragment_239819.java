public class Stuff<E> {
  E bar;
  Iterator<E> foo() {
    class InIterator<Z> implements Iterator<E> {
      @Override public boolean hasNext() { return false; }
      @Override public E next() { return bar;  }
      @Override public void remove() { }
    }
    return new InIterator<Void>();
  }
}