public static void main(String[] args) {
    System.out.println(Arrays.deepToString(findSets(
            new int[] {1,5,7,8,6},
            new int[] {5,7,1,8,6})));
}
static int[][] findSets(int[] ref, int[] values) {
    List<int[]> sets = new ArrayList<>();
    for (int i = 0, len; i < values.length; i += len) {
        // Find value in 'ref' array
        int j = 0;
        while (ref[j] != values[i])
            j++;
        // Find length of matching sub-array
        len = 1;
        while (i + len < values.length && j + len < ref.length && ref[j + len] == values[i + len])
            len++;
        // Add to result
        sets.add(Arrays.copyOfRange(values, i, i + len));
    }
    return sets.toArray(new int[sets.size()][]);
}