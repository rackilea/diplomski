executor.shutdown();

try {
    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
}
catch (InterruptedException e) {
    e.printStackTrace();
}