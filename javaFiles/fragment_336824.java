// passed array will be (partially) sorted
private static int[] getMedian(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = median(Arrays.copyOfRange(arr, 0, i+1));
    }
    return result;
}