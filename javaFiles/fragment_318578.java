public static <T extends Comparable<T>> T min(T[][]stuff) {
    T min = stuff[0][0];
    for (T[] row : stuff) {
        for (T elt : row) {
            if (elt.compareTo(min) < 0)
                min = elt;
        }
    }

    return min;
}