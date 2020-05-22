Observable<Integer> databaseQuery = Observable
    .just(1, 2, 3, 4)
    .delay(500, TimeUnit.MILLISECONDS);

Observable<Integer> result = Observable
        .timer(1, 2, TimeUnit.SECONDS)
        .onBackpressureDrop()
        .concatMap(t -> databaseQuery);

result.subscribe(System.out::println);

Thread.sleep(10000);