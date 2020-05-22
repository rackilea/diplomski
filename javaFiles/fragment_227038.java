public static <T> LinkedList<T> removeUntil(LinkedList<T> list, int index) {
    for (int i = 0; i < index; i++) {
        list.removeFirst();
    }

    return list;
}