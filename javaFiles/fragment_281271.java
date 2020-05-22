public static void ensureSize(ArrayList<?> list, int size) {
    // Prevent excessive copying while we're adding
    list.ensureCapacity(size);
    while (list.size() < size) {
        list.add(null);
    }
}