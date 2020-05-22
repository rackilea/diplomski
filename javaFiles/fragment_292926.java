private final ConcurrentMap<Integer, Observable<User>> userCache = Maps.newConcurrentMap();

public Observable<User> getUser(int id) {
    return userCache.computeIfAbsent(id, theId -> {
        ConnectableObservable<User> cachedObservable = getUserFromApi(id)
                .replay();
        cachedObservable.connect();
        return cachedObservable;
    }).doOnError(err -> userCache.remove(id));
}