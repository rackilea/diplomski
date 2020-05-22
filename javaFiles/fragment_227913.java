@Rule
public Stopwatch stopwatch = new Stopwatch() {
    @Override
    protected void succeeded(long nanos, Description description) {
        assertTrue(runtime(TimeUnit.SECONDS) > 1);
    }
};