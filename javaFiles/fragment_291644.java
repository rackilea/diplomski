Flowable<Integer> flowable = Flowable.create(emitter -> {
    Thread myThread = Thread.currentThread();
    emitter.setCancellable(() -> myThread.interrupt());

    for (int i = 1; i <= number; ++i) {
        if (Thread.interrupted()) {
            // Handle interrupt happening while Thread.sleep
            //  was not executing here.
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
        emitter.onNext(i);
    }
    emitter.onComplete();
}, BackpressureStrategy.BUFFER);