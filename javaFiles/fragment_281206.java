public static <T extends Comparable<T>> T max(T a, T b) {
    int n = a.compareTo(b);
    if (n > 0)
        return a;
    if (n < 0)
        return b;
    return a;
}