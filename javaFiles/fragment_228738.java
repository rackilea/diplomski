public static void main(String[] args) {
    // Added the following warmup loop before the timing loop
    for (int i = 0; i < 50000; i++) {
        functionA(6, 0);
    }

    long startTime = System.nanoTime();
    for (int i = 0; i < 50000; i++) {
        functionA(6, 0);
    }
    long endTime = System.nanoTime();
    System.out.format("%.2f seconds elapsed.\n", (endTime - startTime) / 1000.0 / 1000 / 1000);
}