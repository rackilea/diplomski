public int[] chunk(int m, int n) {
    if (n < 2) return null;
    if (m < 2) m = 2;
    if (n < m) throw new IllegalArgumentException("Borked");
    int root = (int)Math.sqrt((double)n);
    boolean[] sieve = new boolean[n-m+1];
    // primes is the global array of primes to 31621 populated earlier
    // primeCount is the number of primes stored in primes, i.e. 3401
    // We ignore even numbers, but keep them in the sieve to avoid index arithmetic.
    // It would be very simple to omit them, though.
    for(int i = 1, p = primes[1]; i < primeCount; ++i) {
        if ((p = primes[i]) > root) break;
        int mult;
        if (p*p < m) {
            mult = (m-1)/p+1;
            if (mult % 2 == 0) ++mult;
            mult = p*mult;
        } else {
            mult = p*p;
        }
        for(; mult <= n; mult += 2*p) {
            sieve[mult-m] = true;
        }
    }
    int count = m == 2 ? 1 : 0;
    for(int i = 1 - m%2; i < n-m; i += 2) {
        if (!sieve[i]) ++count;
    }
    int sievedPrimes[] = new int[count];
    int pi = 0;
    if (m == 2) {
        sievedPrimes[0] = 2;
        pi = 1;
    }
    for(int i = 1 - m%2; i < n-m; i += 2) {
        if (!sieve[i]) {
            sievedPrimes[pi++] = m+i;
        }
    }
    return sievedPrimes;
}