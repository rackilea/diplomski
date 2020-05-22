public static boolean check(final int n) {
    int m = Math.abs(n);
    while (m > 0) {
        if (m % 10 == 7)
            return true;

        m /= 10;
    }

    return n % 7 == 0;
}