Observable<Long> source1 = Observable.interval(100, 100, TimeUnit.MILLISECONDS).take(10);
Observable<Long> source2 = Observable.interval(100, 100, TimeUnit.MILLISECONDS).take(20);
Observable<Long> source3 = Observable.interval(100, 100, TimeUnit.MILLISECONDS).take(15);

Observable<Observable<Long>> sources = Observable.just(source1, source2, source3);

sources.map(v -> {
    Observable<Long> c = v.cache();
    c.subscribe(); // to cache all
    return c;
})
.onBackpressureBuffer() // make sure all source started
.concatMap(v -> v)
.toBlocking()
.forEach(System.out::println);