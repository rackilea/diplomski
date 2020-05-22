public static Set<int[]> addIfNotExist(Set<int[]> result, int[] array) {
    Arrays.sort(array);
    boolean check = result.stream()
            .anyMatch(a -> {
                Arrays.sort(a);
                return Arrays.equals(a, array);
            });
    if (check) {
        return result;
    } else {
        result.add(array);
        return result;
    }
}