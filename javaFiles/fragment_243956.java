private static class MeasurableAction1<T> implements Action1<T> {
    private Stopwatch measure = Stopwatch.createUnstarted();
    private Action1<? super T> action;

    public MeasurableAction1(Action1<? super T> action) {
        this.action = action;
    }

    @Override
    public void call(T t) {
        action.call(t);
    }

    public MeasurableAction1<T> start() {
        measure.start();
        return this;
    }

    public MeasurableAction1<T> stop() {
        measure.stop();
        return this;
    }

    public long elapsed(TimeUnit desiredUnit) {
        return measure.elapsed(desiredUnit);
    }

    public static <T> MeasurableAction1<T> measure(Action1<? super T> action) {
        return new MeasurableAction1<>(action);
    }
}