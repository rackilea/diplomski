NotifyingQueue<T> extends ForwardingBlockingQueue<T> implements BlockingQueue<T> {
  private final Notifier notifier; // injected not null

  …

  @Override public void put(T element) {
    if (getDelegate().isEmpty()) {
      notifier.notEmptyAnymore();
    }
    super.put(element);
  }

  @Override public T poll() {
    final T result = super.poll();
    if ((result != null) && getDelegate().isEmpty())
      notifier.nowEmpty();
  }
  … etc
}