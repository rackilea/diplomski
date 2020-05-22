private int[] getDistinct(int[] array) {
    Set<Integer> distinct = new HashSet<>();
    int endIdx = 0;

    for (int element : array) {

        if (distinct.add(element)) {
            array[endIdx++] = element;
        }
    }

    return Arrays.copyOfRange(array, 0, endIdx);
}