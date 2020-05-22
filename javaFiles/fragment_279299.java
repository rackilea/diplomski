Integer[][] pattern = new Integer[][]{
        { 1, 1, 1, 1, 1, 1, 1 },
        { 1, 2, 0, 0, 0, 2, 1 },
        { 1, 0, 3, 0, 3, 0, 1 },
        { 1, 0, 0, 4, 0, 0, 1 },
        { 1, 0, 3, 0, 3, 0, 1 },
        { 1, 2, 0, 0, 0, 2, 1 },
        { 1, 1, 1, 1, 1, 1, 1 },
};
List<List<Integer>> lists = new ArrayList<>();
for (Integer[] ints : pattern) {
    lists.add(Arrays.asList(ints));
}