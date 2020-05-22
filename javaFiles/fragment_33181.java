private Observable doThings() {
    return Observable.just(1)
        .flatMap(__ -> withTimeout(doSomething1, 10, TimeUnit.SECONDS))
        .flatMap(__ -> withTimeout(doSomething2, 10, TimeUnit.SECONDS));
        // etc
}

private static <T> Observable<T> withTimeout(Observable<T> observable, long time, TimeUnit timeUnit) {
    return observable
            .timeout(time, timeUnit);
}