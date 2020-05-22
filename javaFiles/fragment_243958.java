private static class MeasuringSubscriber<T> extends Subscriber<T> {
    private Stopwatch measure = Stopwatch.createUnstarted();
    private Action1<? super T> onNext;
    private final Action1<Throwable> onError;
    private final Action0 onComplete;

    public MeasuringSubscriber(Action1<? super T> onNext, Action1<Throwable> onError, Action0 onComplete) {
        this.onNext = onNext;
        this.onError = onError;
        this.onComplete = onComplete;
    }

    @Override
    public void onCompleted() {
        try {
            onComplete.call();
        } finally {
            stopAndPrintMeasure();
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            onError.call(e);
        } finally {
            stopAndPrintMeasure();
        }
    }

    @Override
    public void onNext(T item) {
        onNext.call(item);
    }

    @Override
    public void onStart() {
        measure.start();
        super.onStart();
    }

    private void stopAndPrintMeasure() {
        measure.stop();
        System.out.println("took " + measure);
    }

    private static <T> MeasuringSubscriber<T> measuringSubscriber(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onComplete) {
        return new MeasuringSubscriber<>(onNext, onError, onComplete);
    }
}