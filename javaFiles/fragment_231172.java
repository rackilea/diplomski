public static void main(String[] args) throws Exception {
    ReflectionTest rt = new ReflectionTest();
    // Warm up
    for (int i = 0; i < 100; i++) {
        test.invoke(rt, null);
    }
    for (int i = 0; i < 100; i++) {
        rt.testMethod();
    }

    long start = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
        test.invoke(rt, null);
    }
    long end = Math.abs((start - System.nanoTime()) / 1000);
    start = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
        rt.testMethod();
    }
    long end2 = Math.abs((start - System.nanoTime()) / 1000);
    System.out.printf("%d %d%n", end, end2);
}