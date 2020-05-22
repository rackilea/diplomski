public static <T extends Comparable<? super T>> void insertionSort(List<T> a) {
    final int len = a.size(); // <-- from a.length
    for (int index = 0; index < len; index++) {
        T key = a.get(index); // <-- from a[index]
        int position = index;
        while (position > 0 && a.get(position - 1).compareTo(key) > 0) {
            a.set(position, a.get(position - 1)); // from a[position] = a[position-1];
            position--;
        }
        a.set(position, key); // <-- from a[position] = key;
    }
}