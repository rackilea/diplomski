public static int[] mergeArrays(int[] arr1, int[] arr2) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0, length = arr1.length; i < length; i++) {
        list.add(arr1[i]);
    }
    for (int i = 0, length = arr2.length; i < length; i++) {
        if (!list.contains(arr2[i])) {
            list.add(arr2[i]);
        }
    }
    int length = list.size();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
        result[i] = list.get(i);
    }
    return result;
}