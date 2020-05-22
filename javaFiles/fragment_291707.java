stream.groupBy(group -> group.geName())
    .map(receptor -> observeSource(receptor))
    .forEach(source -> {
        source
            .buffer(2, 1)
            .filter(items -> items.size() == 2)
            .map(pairs -> computeDelay(pairs.get(0), pairs.get(1)))
            .doOnNext(delay -> checkDelay(delay))
            .subscribe();
    });
}