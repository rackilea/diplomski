<T> NonGeneric(T[] blank, List<T> list) {
    // Sort that list
    T[] array = list.toArray(blank);
    Arrays.sort(array);

    // Pull out the values as strings
    this.list = new ArrayList<String>(array.length);
    for (T value : array) {
        this.list.add(value.toString());
    }
}