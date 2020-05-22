@Test
  void nameX() {
    Observable<String> stringObservable = get();

    Observable<String> fallback$ =
        stringObservable
            .doOnError(s -> System.out.println("fail -> " + s.getMessage()))
            .onErrorResumeNext(
                throwable -> {
                  if (throwable instanceof MyException) {
                    return fallBack().doOnNext(s -> System.out.println("use fallback value " + s));
                  } else {
                    return Observable.error(throwable);
                  }
                });

    fallback$
        .test()
        .assertNotComplete()
        .assertValueCount(1)
        .assertValueAt(0, s -> "Wurst".equals(s));
  }

  private Observable<String> get() {
    return Observable.error(new MyException("Fail"));
  }

  private Observable<String> fallBack() {
    return Observable.just("Wurst").mergeWith(Observable.never());
  }

  private static final class MyException extends Exception {
    MyException(String message) {
      super(message);
    }
  }