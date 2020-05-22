static Set<int[]> result = new LinkedHashSet<>();

public static void main(String[] args) {

    int[] x = {1, 2, 3};
    int[] z = {2, 1, 3};
    int[] m = {2, 1, 3};

    addIfNotExist(result, x);
    addIfNotExist(result, z);
    addIfNotExist(result, m);

    for (int[] arr : result) {
        System.out.println(Arrays.toString(arr));
    }
}

public static void addIfNotExist(Set<int[]> result, int[] array) {
    Arrays.sort(array);
    boolean check = result.stream()
            .anyMatch(a -> {
                Arrays.sort(a);
                return Arrays.equals(a, array);
            });
    if (!check) {
        result.add(array);
    }
}