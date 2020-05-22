public static boolean arraysMatch(int[] array1, int[] array2) {
    int[] combined = new int[array2.length * 2];
    System.arraycopy(array2, 0, combined, 0, array2.length);
    System.arraycopy(array2, 0, combined, array2.length, array2.length);
    return Collections.indexOfSubList(Arrays.asList(combined), Arrays.asList(array1)) != -1;
}