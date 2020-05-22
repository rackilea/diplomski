void pause() {
    try {
        TimeUnit.MILLISECONDS.sleep(...);
    } catch (final InterruptedException e) {
        throw new IllegalStateException("interrupted");
    }
}