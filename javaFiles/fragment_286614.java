public static List<Integer> modifyList(List<Integer> list) {
    List<Integer> result = new ArrayList<>(list.size());

    int i = 0, j = list.size() - 1;
    int r = 0;
    while (r < list.size()) {
        result.add(r++, list.get(i++));
        if (i < j)
            result.add(r++, list.get(j--));
    }

    return result;
}