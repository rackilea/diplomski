long startTime = System.currentTimeMillis();

result.whenComplete(new BiConsumer<T, U>() {
    private final long _startTime = startTime;

    @Override public void accept(T res, U err) {
        System.out.println(System.currentTimeMillis() - _startTime);
    }
});