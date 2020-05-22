public Observable<D> getAll(Iterable<RequestPair> requests) {
    return Observable.from(requests)
    .flatMap(request ->
        Observable.zip(
            feignClientA.sendRequest(request.A()),
            feignClientB.sendRequest(request.B()),
            (a, b) -> new C(a,b)
        )
    , 8)  // maximum concurrent HTTP requests
    .map(both -> doSomeWork(both));
}

// for legacy users of the API
public Collection<D> getAllBlocking(Iterable<RequestPair> requests) {
    return getAll(requests)
        .toList()
        .toBlocking()
        .first();
}