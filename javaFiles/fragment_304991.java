public static int trailingZeroesV2(int n) {
    return trailingZeroesV2(n, 5);
}

private static int trailingZeroesRec(int n, int base) {
    return n == 0 ? 0 : n / base + trailingZeroesRec(n / 5, base * 5);
}