// an iterator wrapping another one adding the timeout functionality
class TimeOutIterator<T> implements Iterator<T> {
  final Iterator<T> source;
  final long deadline;

  public TimeOutIterator(Iterator<T> dataSource, long timeout, TimeUnit unit) {
    source=dataSource;
    deadline=System.nanoTime()+unit.toNanos(timeout);
  }
  private void check() {
    if(System.nanoTime()-deadline >= 0)
      throw new RuntimeException("timeout reached");
  }
  public boolean hasNext() {
    check();
    return source.hasNext();
  }
  public T next() {
    check();
    return source.next();
  }
  public void remove() {
    check();
    source.remove();
  }
}