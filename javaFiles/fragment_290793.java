private static boolean lrsumsEqual(List<Integer> ints, int index) {
    int left = 0;
    List<Integer> llist = ints.subList(0, index);

    for (int i : llist) {
        left = left + i;
    }

    int right = 0;
    List<Integer> rlist = ints.subList(index + 1, ints.size());

    for (int i : rlist) {
        right = right + i;
    }

    // int left = ints.stream().limit(index).mapToInt(Integer::intValue).sum();
    // int right = ints.stream().skip(index + 1).mapToInt(Integer::intValue).sum();

    return left == right;