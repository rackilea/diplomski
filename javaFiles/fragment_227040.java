public static <T> LinkedList<T>[] split(LinkedList<T> list, int index) {
    LinkedList<T> left = new LinkedList<>();

    for (int i = 0; i < index; i++) {
        T t = list.removeFirst();
        left.addLast(t);
    }

    return new LinkedList[] {
        left, list
    };
}