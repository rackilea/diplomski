static <T> void process(List<T> list1, List<T> list2, List<T> insertList, List<T> deleteList) {
    for (T t: list1) {
        if (!list2.contains(t)) {
            insertList.add(t);
        }
    }
    for (T t: list2) {
        if (!list1.contains(t)) {
            deleteList.add(t);
        }
    }
}