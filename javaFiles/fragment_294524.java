public static int binomial(int n, int k) {
    int nMinusK = n - k;
    if (n < nMinusK) {
        //Switch n and nMinusK
        int temp = n;
        n = nMinusK;
        nMinusK = temp;
    }

    int result = 1;

    //  n!/k!
    for (int i = k + 1; i <= n; i++) {
        result *= i;
    }

    //Division by (n-k)!
    for (int j = 1; j <= nMinusK; j++) {
        result = result / j;
    }
    return result;
}