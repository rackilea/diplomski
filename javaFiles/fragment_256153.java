final class OnceObservable {

    final AtomicReference<Observable<Integer>> ref = new AtomicReference<>();

    int x;
    int y;

    Observable<Integer> concat() {
        Observable<Integer> obs = ref.get();
        if (obs != null) {
            return;
        }

        obs = Observable.concatDelayError(
            Observable.fromCallable(() -> doSomething()),
            Observable.fromCallable(() -> doSomethingElse())
        )
        .doOnSubscribe(() -> {
            x = 10;
            y = 20;
        })
        .replay().autoConnect();

        if (!ref.compareAndSet(null, obs)) {
            obs = ref.get();
        }
        return obs;
    }
}