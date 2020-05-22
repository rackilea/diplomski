public static void merge(List<Integer> l1, List<Integer> l2) {
    for (int index2 = 0; index2 < l2.size(); index2++) {
        for (int index1 = 0; ; index1++) {
            if (index1 == l1.size() || l1.get(index1) > l2.get(index2)) {
                l1.add(index1, l2.get(index2));
                break;
            }
        }
    }
}