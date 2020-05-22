public static boolean arraysMatch(int[] array1, int[] array2) {
    return Collections.indexOfSubList(
        Arrays.asList(ArrayUtils.toObject(ArrayUtils.addAll(array2, array2))),
        Arrays.asList(ArrayUtils.toObject(array1))
    ) != -1;
}