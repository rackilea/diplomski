public static long fib(int n) {
    long a = 0, b = 1;
    if (n <= 1) { return n; }
    for (int i = 2; i < n; ++i) {
        int tmp = b;
        b += a;
        a = tmp;
    }
    return b;
}