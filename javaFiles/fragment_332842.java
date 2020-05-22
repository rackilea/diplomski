private long calculateAvg(Runnable r) {
    //...
    long startTime = System.nanoTime();
    r.run();
    long endTime = System.nanoTime();
    //...
}