private static Observable<Double> averageOf(Observable<Double> data, Scheduler scheduler) {

    ConnectableObservable<? extends Double> hot = data
            .publish();

    // call the underlying connect() after the 2nd subscription
    Observable<Double> bridge = Observable.create(new OnSubscribeRefCountN<>(hot, 2))
            .subscribeOn(scheduler);

    Observable<Double> count = bridge.count()
            .map(Integer::doubleValue);

    Observable<Double> sum = bridge.reduce(0.0, (seed, e) -> seed + e);

    return Observable.zip(sum, count, (s, c) -> s / c);
}