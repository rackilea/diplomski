@Test
    public void stop_watch_observable() {

        Observable<Long> insertions = insertions();
        Observable<Long> shared = insertions.share();

        AtomicBoolean timerOn = new AtomicBoolean(false);

        Observable<Long> window = shared
                .flatMap(e -> timerOn.get() ? Observable.empty() : Observable.timer(3, TimeUnit.SECONDS)
                        .doOnSubscribe(x -> timerOn.set(true))
                );

        shared.buffer(window)
                //each time a window is generated we kill all the current timers
                .doOnNext(e -> timerOn.set(false))
                .blockingSubscribe(System.out::println);
    }