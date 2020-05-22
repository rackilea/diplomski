@SuppressWarnings("unchecked")
private static List<List<List<Integer>>> split(List<Integer> list, int groups) {
    if (groups <= 0 || groups > list.size())
        throw new IllegalArgumentException("Invalid number of groups: " + groups +
                                           " (list size: " + list.size() + ")");
    List<List<List<Integer>>> result = new ArrayList<>();
    split(list, 0, new List[groups], 0, result);
    return result;
}
private static void split(List<Integer> list, int listIdx,
                          List<Integer>[] combo, int comboIdx,
                          List<List<List<Integer>>> result) {
    if (combo.length - comboIdx == 1) {
        combo[comboIdx] = list.subList(listIdx, list.size());
        result.add(new ArrayList<>(Arrays.asList(combo)));
    } else {
        for (int i = 0; i <= (list.size() - listIdx) - (combo.length - comboIdx); i++) {
            combo[comboIdx] = list.subList(listIdx, listIdx + 1 + i);
            split(list, listIdx + 1 + i, combo, comboIdx + 1, result);
        }
    }
}