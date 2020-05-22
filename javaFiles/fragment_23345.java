public static void asterisk(int m, int n) {
    printAsterisk(m);
    if (m < n) {
        asterisk(m + 1, n);
    }
    printAsterisk(m);
}