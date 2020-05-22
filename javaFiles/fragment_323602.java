static String toSymbol(int in) {
    String[] p = { "", "K", "M", "G" };
    int k = 1000;
    assert pow(k, p.length) - 1 > Integer.MAX_VALUE;
    int x = in;
    for (int i = 0; i < p.length; i++) {
        if (x < 0 ? -k < x : x < k) return x + p[i];
        x = x / k;
    }
    throw new RuntimeException("should not get here");
}