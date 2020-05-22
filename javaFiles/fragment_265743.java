static int abs(int n) {
    int s = n >>> 31;
    n ^= n >> 31;

    int c = (n & s) << 1;
    c = ((n ^= s) & (s = c)) << 1; // repeat this line 30 more times
    n ^= s;

    return n;
}