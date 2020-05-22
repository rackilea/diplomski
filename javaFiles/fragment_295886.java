Observable.create((ObservableEmitter<? super String> s) -> {
      System.out.println("subscribing");
      s.onError(new RuntimeException("always fails"));
  }).retryWhen(attempts -> {
      return attempts.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
          System.out.println("delay retry by " + i + " second(s)");
          return Observable.timer(i, TimeUnit.SECONDS);
      });
  }).blockingForEach(System.out::println);