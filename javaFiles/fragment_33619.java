long startTime = System.currentTimeMillis();

result.whenComplete(new BiConsumer<T, U>() {
    @Override public void accept(T res, U err) {
        System.out.println(System.currentTimeMillis() - startTime);
    }
});