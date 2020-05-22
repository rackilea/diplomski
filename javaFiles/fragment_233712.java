private void sleepRandomly() {
    try {
        Thread.sleep(getMillis());
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}

private static long getMillis() {
    return (long) (Math.random() * 20_000 + 30_000);
}