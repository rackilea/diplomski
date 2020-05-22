public Flux<Item> observe(long id) {
        final AtomicLong nextStartId = new AtomicLong(id);
        return Flux.defer(() -> getNew(nextStartId.get()))
                .doOnNext(item -> nextStartId.set(item.id))
                .repeat();
    }