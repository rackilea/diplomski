Flowable<Integer> f = ....
f.subscribeOn(Schedulers.newThread())
    .parallel()                          // <---------------------------------
    .runOn(Schedulers.computation())     // <---------------------------------
    .filter(i -> i % 2 == 0)
    .doOnNext(i -> {
      System.out.println("parallel thread in: " + threadName());
      System.out.println("parallel: " + i);
      Thread.sleep(10);
    })
    .sequential()                        // <---------------------------------
    .subscribe(
            number -> System.out.println(threadName() + ": " + number),
            throwable -> System.err.println(threadName() + ": " + throwable.toString()),
            () -> System.out.println(threadName() + ": Completed!")
    );

    Thread.sleep(10000);