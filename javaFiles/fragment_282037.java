Observable<Void> o = Observable.create(new Observable.OnSubscribe<Void>() {
    @Override
    public void call(Subscriber<? super Void> subscriber) {
        // Do the work and call onCompleted when you done,
        // no need to call onNext if you have nothing to emit
        subscriber.onCompleted();
    }
});

o.subscribe(new OnCompletedObserver<Void>() {
    @Override
    public void onCompleted() {
        System.out.println("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("onError " + e.getMessage());
    }
});