static List<int[]> combinations(int[] arr, int n, int pos, int[] result) {
    List<int[]> list = new ArrayList<>(25);
    if (n == 0) {
        list.add(Arrays.copyOf(result, result.length));
    } else {
        for (int i = pos; i <= arr.length - n; i++) {
            result[result.length - n] = arr[i];
            list.addAll(combinations(arr, n - 1, pos + 1, result));
        }
    }
    return list;
}