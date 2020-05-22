public long measure(Runnable testCode, int warmupIterations, int testIterations) {
    // warmup
    for(int i = 0; i < warmupIterations; i++) {
        testCode.run();
    }

    // test
    long time = System.currentTimeMillis();
    for(int i = 0; i < testIterations; i++) {
        testCode.run();
    }
    long elapsed = System.currentTimeMillis() - time;

    return elapsed / testIterations;
}