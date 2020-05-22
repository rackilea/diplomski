AtomicBoolean executed = new AtomicBoolean(false);
Observable
  .empty()
  .doOnNext(t -> executed.set(true))
  .subscribe();
assertFalse(executed.get());