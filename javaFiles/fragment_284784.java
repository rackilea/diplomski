public static long compose(int hi, int lo) {
    return (((long) hi << 32) + unsigned(lo));
}
public static long unsigned(int x) {
    return x & 0xFFFFFFFFL;
}

public static int high(long x) {
    return (int) (x>>32);
}
public static int low(long x) {
    return (int) x;
}