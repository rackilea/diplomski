Observable.zip(Observable.range(1, 5)
        .groupBy(n -> n % 5)
        .flatMap(g -> g.toList()),
    Observable.interval(50, TimeUnit.MILLISECONDS),
    (obs, timer) -> obs)
    .doOnNext(item -> {
      System.out.println(System.currentTimeMillis() - timeNow);
      System.out.println(item);
      System.out.println(" ");
    }).toList().toBlocking().first();