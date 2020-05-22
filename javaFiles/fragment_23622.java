public static boolean isAbundant(long n) {
    long val = 1;
    for (int i = 2; i*i <= n; i++)
        if (n % i == 0)
            val += i;
        return val == n;
}