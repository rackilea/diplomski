static volatile String dontOptimiseAway = null;
public static void testRandomBigInteger(Random random) {
    long start = System.nanoTime();
    int runs = 10000;
    for(int i=0;i< runs;i++) {
        dontOptimiseAway = new BigInteger(130, random).toString(36);
    }
    long time = System.nanoTime() - start;
    System.out.printf("%s took %.1f micro-seconds on average%n", random.getClass().getSimpleName(), time/runs/1e3);
}
public static void main(String... ignored) {
    for (int i = 0; i < 10; i++) {
        testRandomBigInteger(new Random());
        testRandomBigInteger(new SecureRandom());
    }
}