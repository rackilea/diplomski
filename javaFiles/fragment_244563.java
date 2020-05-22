private static <T extends Comparable<T>> List<List<T>> split(
       List<T> original, T delimiter) {

    List<List<T>> res = new ArrayList<>();

    List<T> current = new ArrayList<>();
    for (T f : original) {
        if (f.compareTo(delimiter) == 0) {
            res.add(current);
            current = new ArrayList<>();
            continue;
        }

        current.add(f);
    }

    if (!current.isEmpty()) {
        res.add(current);
    }

    return res;
}