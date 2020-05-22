static void sort(List<Integer> list) {
    if (!list.isEmpty()) {
        int pivotValue = list.get(list.size() - 1);
        int storeIndex = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < pivotValue) {
                Collections.swap(list, i, storeIndex++);
            }
        }
        Collections.swap(list, list.size() - 1, storeIndex);
        sort(list.subList(0, storeIndex));
        sort(list.subList(storeIndex + 1, list.size()));
    }
}