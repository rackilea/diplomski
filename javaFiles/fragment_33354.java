ForkJoinPool pool = new ForkJoinPool(2);

pool().submit(() -> {
mySet
    .parallelStream()
    ... // do my fancy stuff and collect
})