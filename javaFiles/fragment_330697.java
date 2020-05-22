class MyCallable implements Callable<V> {
    P p;
    MyCallable(P parameter) {
        p = parameter;
    }
    V call() {
        return CalcResult(p);
    }
}