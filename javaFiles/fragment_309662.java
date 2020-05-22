public static <T extends Comparable<? super T>> List<List<List<T>>> level(List<List<T>> items, int minLevel, int maxLevel) {
    List<List<List<T>>> result = new ArrayList<>();

    for(int i = minLevel; i < maxLevel+1; i++) {
        result.addAll(level(items, i));
    }

    return result;
}