Flowable.range(1, 7)
    .flatMap(v -> Flowable.timer(v * 200, TimeUnit.MILLISECONDS).map(w -> v))
    .doOnNext(v -> System.out.println(v))
// -------------------------------------------------------------------
    .publish(f -> 
        f.skipLast(3).mergeWith(f.takeLast(3))
    )
// -------------------------------------------------------------------
    .blockingSubscribe(v -> System.out.println("<-- " + v));