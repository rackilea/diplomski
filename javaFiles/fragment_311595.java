Flux.range(0, 10)
.parallel()
.runOn(Schedulers.parallel())
.doOnNext(i -> LOG.info(i))
.sequential()
.subscribe();