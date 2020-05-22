public static boolean contains(List<Integer[]> list, Integer[] value) {
    for (Integer[] arr: list) {
        // We can compare two arrays using `Arrays.equals` method.
        if (Arrays.equals(arr, value)) {
            return true;
        }
    }
    return false;
}