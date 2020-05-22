.flatMapIterable(e -> e.getContents())
.buffer(3,TimeUnit.MINUTES,50000)
.rebatchRequests(1)
.observeOn(Schedulers.computation())
.doOnNext(s -> /* Do some logic here */)
.subscribe();