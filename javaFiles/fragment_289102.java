class MoveNextReader<T> implements ResourceAwareItemReaderItemStream<T> {
  private ResourceAwareItemReaderItemStream delegate;
  private boolean skipThisFile = false;

  public void setSkipThisFile(boolean value) {
    skipThisFile = value;
  }

  public void setResource(Resource resource) {
    skipThisFile = false;
    delegate.setResource(resource);
  }

  public T read() {
    if(skipThisFile) {
      skipThisFile = false;
      // This force MultiResourceItemReader to move to next resource
      return null;
    }
    return delegate.read();
  }
}