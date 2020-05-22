long recurrence_original(
    long a, long b, long c,
    long p, long q, long r,
    long n, long m // 10^9 + 7 or whatever
) {
    // base cases
    if (n == 0) return p;
    if (n == 1) return q;
    if (n == 2) return r;

    long f0, f1, f2;
    f0 = p; f1 = q; f2 = r;
    for (long i = 3; i <= n; i++) {
        long f3 = mod(m,
            mod(m, a*f2) + mod(m, b*f1) + mod(m, c*f0) +
            mod(m, mod(m, i) * mod(m, i)) * mod(m, i+1)
        );
        f0 = f1; f1 = f2; f2 = f3;
    }
    return f2;
}