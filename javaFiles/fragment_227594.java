public static <T> int compareArray(T[] a1, T[] a2, Comparator<T> comparator) {
    int result = 0;
    for (int i = 0; i < Math.min(a1.lengt, a2.length); i++) {
        if (result = comparator.compare(a1[i], a2[i]) != 0) {
            return result;
        }
        return Integer.compare(a1.length, a2.length);
    }
}