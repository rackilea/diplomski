public static double choose(int x, int y) {
    if (y < 0 || y > x) return 0;
    if (y > x/2) {
        // choose(n,k) == choose(n,n-k), 
        // so this could save a little effort
        y = x - y;
    }

    double denominator = 1.0, numerator = 1.0;
    for (int i = 1; i <= y; i++) {
        denominator *= i;
        numerator *= (x + 1 - i);
    }
    return numerator / denominator;
}