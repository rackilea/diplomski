public List<T> <K,T> mapToList(Map<K, T> map) {
    List<T> list = new ArrayList<T>();

    list.addAll(map.values());

    return list;
}