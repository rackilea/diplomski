public static int multiplyExact(int x, int y) {
    long r = (long)x * (long)y;
    if ((int)r != r) {
        throw new ArithmeticException("long overflow");
    }
    return (int)r;
}