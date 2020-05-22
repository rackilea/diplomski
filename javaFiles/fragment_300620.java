void pause() {
    try {
        TimeUnit.MILLISECONDS.sleep(...);
    } catch (final InterruptedException e) {
        Thread.interrupted();
    }
}