static int abs(int n) {
    int s = n >>> 31;
    n ^= n >> 31;

    int c;
    do {
        c = (n & s) << 1;
        n ^= s;
    } while((s = c) != 0);

    return n;
}