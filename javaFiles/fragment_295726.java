public boolean isPowerOfTwoAND(long x) {
    return x > 0 & (x & (x - 1)) == 0;
}

public boolean isPowerOfTwoANDAND(long x) {
    return x > 0 && (x & (x - 1)) == 0;
}