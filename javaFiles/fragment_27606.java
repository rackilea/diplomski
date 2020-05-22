public <T> List<T> twoDArrayToList(T[][] twoDArray) {
    List<T> list = new ArrayList<T>();
    for (T[] array : twoDArray) {
        list.addAll(Arrays.asList(array));
    }
    return list;
}