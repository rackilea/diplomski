final ExecutorService executor = Executors.newCachedThreadPool();

final ConnectableObservable<?> result = Observable.concat(
    Observable.defer(
        new Func0<Observable<?>>() {
            @Override
            public Observable<?> call() {
                return Observable.from(
                    executor.submit(
                        new Runnable() {
                            @Override public void run() { task(1); }
                        }
                    )
                );
            }
        }
    ),
    Observable.defer(
        new Func0<Observable<?>>() {
            @Override
            public Observable<?> call() {
                return Observable.from(
                    executor.submit(
                        new Runnable() {
                            @Override public void run() { task(2); }
                        }
                    )
                );
            }
        }
    )
).replay();

result.connect();