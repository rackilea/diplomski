class OneItemReader<T> implements ItemReader<T> {
  boolean read = false;
  ItemReader<T> delegate;

  @Override
  public T read() {
    if(read) {
      return null;
    }
    T item = delegate.read();
    read = true;
    return item;
  }
}