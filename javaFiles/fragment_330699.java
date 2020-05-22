@WorkerThread
Flowable<Integer> updateMovies(Helper help) {
    return movieDao.getMovies()
        .firstOrError()
        .flatMapIterable(movies -> movies)
        .flatMap(movie -> { ... })
        .map(movie -> { ... });
}