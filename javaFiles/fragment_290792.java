public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 7, 10, 2, 8);
    // List<Integer> ints = Arrays.asList(1, -1, 1, -1, 1, -1, 1, -1, 1);
    // List<Integer> ints = Arrays.asList(0, 1, -1);

    printEqualAtIndexes(ints);

}

private static void printEqualAtIndexes(List<Integer> ints) {
    for (int i = 0; i < ints.size(); i++) {
        boolean lrsumsEqual = lrsumsEqual(ints, i);
        if (lrsumsEqual) {
            System.out.println("Equal at index " + i + ", that is element " + ints.get(i));
        }
    }
}

private static boolean lrsumsEqual(List<Integer> ints, int index) {

    int left = ints.stream().limit(index).mapToInt(Integer::intValue).sum();
    int right = ints.stream().skip(index + 1).mapToInt(Integer::intValue).sum();

    return left == right;
}