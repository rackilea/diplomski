public Observable<Notification<String>> getStreamData() {
    return Observable.create(o -> {
        o.onNext (Notification.createOnNext("hello1"));
        o.onNext (Notification.createOnNext("hello2"));
        o.onError(Notification.createOnError(new TimeoutException("Timed Out!")));
        o.onNext (Notification.createOnNext("hello3"));
        o.onComplete();
    });
}