List<Item> cache;

Flowable<Item> getRange(int start, int amount) {

    ...
        if (isFullyCached) return Flowable.fromCallable(() -> {
            throw new Exception("OutOfBounds");
        });

        //To not deal with gaps load and cache data between;
        //Or replace it with data structure which can handle for us;
        daoFlow = dao.getRange(
                uri,
                cacheSize,
                start - cacheSize + amount);
        //all these items should be cached;
        //other cached and put downstream;
            .doOnNext(result -> /* insert caching logic here */)
        //Dao errs should be converted to higher lever exceptions,
        //Or set flags in DataSource;
            .doOnError(error -> /* handle error here */)
            .onErrorReturn(/* and/or return some empty item */)
    }
    // return concatenated flowable;
    return cacheFlow.concat(daoFlow);
}