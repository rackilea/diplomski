// Max digits.
private static final int DIGITS = 20;
// Indicates an empty digit.
private static final int EMPTY = -1;
// Max value I can handle.
private static final long MAX = (long) Math.cbrt(Long.MAX_VALUE);

public static int isIsolated(long n) {

    if (n > 1 && n < MAX) {
        long square = n * n;
        long cube = n * n * n;
        long[] a = new long[DIGITS];
        Arrays.fill(a, EMPTY);
        long[] b = new long[DIGITS];
        Arrays.fill(b, EMPTY);
        for (int i = 0; i < DIGITS; i++) {
            if (square > 0) {
                a[i] = square % 10;
                square = square / 10;
            }
            if (cube > 0) {
                b[i] = cube % 10;
                cube = cube / 10;
            }
        }

        for (int i = 0; i < DIGITS; i++) {
            if (a[i] != EMPTY) {
                for (int j = 0; j < DIGITS; j++) {
                    if (a[i] == b[j]) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    return -1;
}

public void test(int n) {
    System.out.println(n + " is " + (isIsolated(n) == 1 ? "" : "not ") + "isolated");
}

public void test() {
    System.out.println("Hello");
    test(1234);
    test(69);
    test(162);
    for (long i = 0; i < MAX; i++) {
        if (isIsolated(i) == 1) {
            System.out.println(i + " is isolated - ^2 = " + (i * i) + " ^3 = " + (i * i * i));
        }
    }
}