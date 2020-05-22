public static <T> T[][] toArray(List<List<T>> list, Class<T> clazz) {
    if (list == null) {
        return null;
    }
    List<T[]> temp = new ArrayList<>();
    @SuppressWarnings("unchecked")
    T[] inner = (T[]) Array.newInstance(clazz, 0);
    for (List<T> sublist : list) {
        temp.add(sublist == null ? null : sublist.toArray(inner));
    }
    @SuppressWarnings("unchecked")
    T[][] outer = (T[][]) Array.newInstance(inner.getClass(), temp.size());
    return temp.toArray(outer);
}