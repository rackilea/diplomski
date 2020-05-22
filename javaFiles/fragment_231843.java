static <T extends Comparable<T>> T min(T a, T b) {
    return (a.compareTo(b) < 0) ? a : b;
}

{
    // returns "x"
    String s = min("x", "z");
    // returns -1
    Integer i = min(1, -1);
}