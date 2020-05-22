.toFlowable(BackpressureStrategy.BUFFER)
.parallel()
.runOn(Schedulers.computation())
.map(e -> e.getContents())
.flatMap(s -> Flowable.fromIterable(s))
.sequential()
.buffer(3,TimeUnit.MINUTES,50000)
.subscribe(new Subscriber<List<String>>() { ... });