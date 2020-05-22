public class ArraySet<T> implements Iterable<T> {

  // snip...

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    @Override
    public boolean hasNext() {
      // your logic here
    }

    @Override
    public T next() {
      // your logic here
    }
  }
}