List<List<Integer>> lists = new ArrayList<>();
for (int[] ints : pattern) {
    List<Integer> list = new ArrayList<>();
    for (int i : ints) {
        list.add(i);
    }
    lists.add(list);
}