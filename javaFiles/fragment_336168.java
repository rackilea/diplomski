public static <T> int ultimateCompare(T o1, T o2, Function<T, Comparable>... getters) {
    for (Function<T, Comparable> getter : getters) {
        int result = getter.apply(o1).compareTo(getter.apply(o2));
        if (result != 0) return result;
    }
    return 0;
}