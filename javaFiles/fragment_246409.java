public static boolean compareArrays(Integer[] arr1, Integer[] arr2) {
    // TODO: Null validation...
    if (arr1.length != arr2.length) {
        return false;
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
}