public static int itP(int n) {
    if (n <= 2) {
        return 1;
    }

    int n3 = 1;
    int n2 = 1;
    int n1 = 1;

    for (int i = 3; i <= n; i++) {
        int m = n3 * n1 + 1;
        n1 = n2;
        n2 = n3;
        n3 = m;
    }
    return n3;
}