public static <T extends Number> T smallest(List<T> l) {
    T lowest = l.get(0);
    for (T index : l) {
        if (myComparator.compareTo(index, lowest) < 0) { 
            index = lowest;
        }
    }
    return lowest;
}