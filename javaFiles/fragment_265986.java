public static int[] mergeArrays(int[] arr1, int[] arr2) {
    Set<Integer> set = new HashSet<Integer>();
    for (int x : arr1) {
        set.add(x);
    }
    for (int x : arr2) {
        set.add(x);
    }
    int[] result = new int[set.size()];
    int index = 0;
    for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
        result[index] = it.next();
        index++;
    }
    return result;
}