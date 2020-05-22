List<List<int[]>> findMaximumSubsets(int[][] arr) {
    List<List<int[]>> acc = new ArrayList<>();
    for (int i = 0; i < arr.length - 1; i++) {
        findMaximumSubsets(arr, i, acc, new ArrayList<>(Collections.singletonList(arr[i])));
    }
    return acc;
}

void findMaximumSubsets(int[][] arr, int row, List<List<int[]>> acc, List<int[]> current) {
    for (int i = row + 1; i < arr.length; i++) {
        if (comparator.compare(arr[row], arr[i]) < 0) {
            // ... (not spoiling for you ...)
        }
    }
}

Comparator<int[]> comparator = new Comparator<int[]>() {
    @Override
    public int compare(int[] a1, int[] a2) {
        int cmp1 = Integer.compare(a1[0], a2[0]);
        if (cmp1 > -1) {
            return 0;
        }
        int cmp2 = Integer.compare(a1[1], a2[1]);
        if (cmp2 > -1) {
            return 0;
        }
        return Integer.compare(a1[2], a2[2]);
    }
};