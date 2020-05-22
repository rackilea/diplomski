AtomicInteger counter = new AtomicInteger();

    // Thread-safe
    // SerializedSubject<Object, Object> subject = PublishSubject.create().toSerialized();

    // Not Thread Safe
    PublishSubject<Object> subject = PublishSubject.create();

    Action1<Object> print = (x) -> System.out.println(Thread.currentThread().getName() + " " + counter);

    Consumer<Integer> sleep = (s) -> {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    subject
            .doOnNext(i -> counter.incrementAndGet())
            .doOnNext(i -> counter.decrementAndGet())
            .doOnNext(print)
            .filter(i -> counter.get() != 0)
            .doOnNext(i -> {
                        throw new NullPointerException("Concurrency detected");
                    }
            )
            .subscribe();

    Runnable r = () -> {
        for (int i = 0; i < 100000; i++) {
            sleep.accept(1);
            subject.onNext(i);
        }
    };

    ExecutorService pool = Executors.newFixedThreadPool(2);
    pool.execute(r);
    pool.execute(r);