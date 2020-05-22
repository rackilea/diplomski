public static void main(String[] args) throws Exception {
    int length = 200000;
    double[] a = fill(new double[length]);
    double[] b = fill(new double[length]);
    double[] c = fill(new double[length]);
    double[] x = new double[length];

    for (int i = 0; i < 10; i++)
        testTime(length, a, b, c, x);
}

private static void testTime(int length, double[] a, double[] b, double[] c, double[] x) {
    long start = System.nanoTime();
    for (int i = 0; i < length; i++)
        x[i] = a[i] * b[i] + c[i];
    long time = System.nanoTime() - start;
    System.out.printf("Average time per double operation was %.1f ns%n", time / 2.0 / length);
}

private static double[] fill(double[] doubles) {
    for (int i = 0; i < doubles.length; i++)
        doubles[i] =  Math.random();
    return doubles;
}