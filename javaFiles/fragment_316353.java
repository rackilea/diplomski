public static long measureExecution(Runnable code) {
    long start = System.nanoTime();
    code.run();
    long time = System.nanoTime() - start;
    return time;
}