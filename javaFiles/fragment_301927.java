AtomicBoolean executed = new AtomicBoolean(false);
Observable
  .empty()
  .doOnNext(Actions.setToTrue(executed))
  .subscribe();
assertFalse(executed.get());