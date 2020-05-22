Observable<Integer> obs = Observable.create(emitter -> {
   try {
      // ...
   } catch (InterruptedException ex) {
      // check if the interrupt is due to cancellation
      // if so, no need to signal the InterruptedException
      if (!disposable.isDisposed()) {
         observer.onError(ex);
      }
   }
});