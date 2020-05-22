public static void main(String... args) {
    long start = System.nanoTime();
    int runs = 10000000;
    for (int i = 0; i < runs; i++) {
        try {
            throwsException();
        } catch (Exception ignored) {
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("Took an average of %.3f micro-second per exception%n", time / runs / 1e3);
}

private static void throwsException() throws Exception {
    throw new Exception("Ignored");
}