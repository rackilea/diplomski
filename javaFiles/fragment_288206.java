public static boolean arraysMatch(int[] array1, int[] array2) {
    List<Integer> combined = new ArrayList<>(array2.length * 2);
    List<Integer> array2List = Arrays.asList(array2);
    combined.addAll(array2List);
    combined.addAll(array2List);
    return Collections.indexOfSubList(combined, Arrays.asList(array1)) != -1;
}