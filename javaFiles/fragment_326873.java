@Override
    protected Flowable<List<List<DataSource>>> loadFromDb() {
        return Flowable.just(parentId).flatMapIterable(d -> d)
                .flatMapMaybe(s -> containerDao.loadContainerByParentIdRx(s))
                .distinct()
                .doOnNext(data -> {
                    // I am able to get data here
                })
                .toList() // You should now get this as well.
                .toFlowable()
                .doOnNext(data -> {
                    // Nothing here
                });
    }