private static List<List<Integer>> splitAndReturn(List<Integer> numbers,
        int size) {
    List<List<Integer>> smallList = new ArrayList<List<Integer>>();
    int i = 0;
    while (i + size < numbers.size()) {
        smallList.add(numbers.subList(i, i + size));
        i = i + size;
    }
    smallList.add(numbers.subList(i, numbers.size()));
    return smallList;
}