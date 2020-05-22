// This one outputs "subscribe.onError" 
@Test
public void observable_doOnError_subscribingToError() throws InterruptedException {
    Observable<String> obs = 
        getErrorProducingObservable()
            .doOnError(throwable -> System.out.println("doOnError"));

    obs.subscribeOn(Schedulers.immediate()).observeOn(Schedulers.immediate()).subscribe(
        s -> {},
        error -> System.out.println("subscribe.onError")
    );
    Thread.sleep(300);
}

// This one outputs "subscribe.onError" 
@Test
public void observable_onErrorReturn() throws InterruptedException {
    Observable<String> obs = 
        getErrorProducingObservable()
            .onErrorReturn(throwable -> "Yeah I got this");

    obs.subscribeOn(Schedulers.immediate()).observeOn(Schedulers.immediate()).subscribe(
        s -> System.out.println("got: " + s),
        error -> System.out.println("subscribe.onError")
    );
    Thread.sleep(300);
}

private Observable<String> getErrorProducingObservable()  {
    return Observable.create(subscriber -> {
        subscriber.onError(new RuntimeException("Somebody set up us the bomb"));
    });
}