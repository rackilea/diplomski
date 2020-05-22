class TickHandler {

    private AtomicLong lastTick = new AtomicLong(0L);
    private Subscription subscription;

    void resume() {
        System.out.println("resumed");
        subscription = Observable.interval(5, TimeUnit.SECONDS, Schedulers.io())
                                 .map(tick -> lastTick.getAndIncrement())
                                 .subscribe(tick -> System.out.println("tick = " + tick));
    }

    void stop() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            System.out.println("stopped");
            subscription.unsubscribe();
        }
    }
}