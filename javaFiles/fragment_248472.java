public static int[] removeDuplicates(int[] arr) {
    Set<Integer> tmp = new LinkedHashSet<Integer>();
    for (Integer item : arr) {
        tmp.add(item);
    }
    int[] output = new int[tmp.size()];
    int i = 0;
    for (Integer item : tmp) {
        output[i++] = item;
    }
    return output;

};
mySortedArray = removeDuplicates(mySortedArray);