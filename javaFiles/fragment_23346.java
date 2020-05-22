public static void asterisk(int m, int n) {
    if (m <= n) {
        printAsterisk(m);
        asterisk(m + 1, n);
        printAsterisk(m);
    }
}