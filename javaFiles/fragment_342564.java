Observable.range(1, 10)
.flatMap(v -> 
    Observable.just(v)
    .subscribeOn(Schedulers.computation())
    .map(v -> v * v)
)
.toBlocking()
.subscribe(System.out::println);