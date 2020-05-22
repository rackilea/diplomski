int invert(int n) {
    return ~n & mask(n);
}
int mask(int n) {
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    return n | (n >> 16);
}