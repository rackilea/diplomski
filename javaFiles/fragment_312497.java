public static List<T> createPrefilledList(int size, T item) {
    ArrayList<T> list = new ArrayList<T>(size);
    for (int i = 0; i < size; i++) {
        list.add(item);
    }
    return list;
}