@Test
void name() throws Exception {
    Observable<Tuple2<Integer, String>> tuple2Observable = Observable.just(1, 2, 3, 4, 5, 6)
            .flatMap(integer ->
                    Observable.fromCallable(() -> getVitalName(integer))
                            .subscribeOn(Schedulers.io())
                            .doOnNext(s -> System.out.println("Value:: " + Thread.currentThread().getName() + "-" + Instant.now()))
                            .map(s -> Tuple.of(integer, s))
            ).doOnComplete(() -> System.out.println("Finished:: " + Thread.currentThread().getName() + "-" + Instant.now()));

    tuple2Observable.test()
            .await();
}

public String getVitalName(int vitalId) throws Exception {
    System.out.println("getVitalName method called with vitalId = " + vitalId + "-" + Thread.currentThread().getName() + "-" + Instant.now());

    Thread.sleep(500);

    String name = "le fake value";
    return name;
}