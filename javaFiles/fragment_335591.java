AtomicStateNotifier implements Notifier {
  private final AtomicBoolean empty = new AtomicBoolean(true); // assume it starts empty
  private final Notifier delegate; // injected not null

  public void notEmptyAnymore() {
    if (empty.get() && empty.compareAndSet(true, false))
      delegate.notEmptyAnymore();
  }

  public void nowEmpty() {
    if (!empty.get() && empty.compareAndSet(false, true))
      delegate.nowEmpty();
  }
}