static <T> ObservableTransformer<T, T> onTimeoutKeepAlive(
        long timeout, TimeUnit unit, Scheduler scheduler, T keepAliveItem) {
    return upstream -> 
        upstream.publish(o ->
            o.mergeWith(
                Observable.timer(timeout, unit, scheduler)
                .map(t -> keepAliveItem)
                .takeUntil(o)
                .repeat()
                .takeUntil(o.ignoreElements().toObservable())
            )
        );
}