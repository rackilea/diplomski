public static <T> List<T> slice(List<T> list, int index, int count) {
    List<T> result = new ArrayList<T>();
    if (index >= 0 && index < list.size()) {
    int end = index + count < list.size() ? index + count : list.size();
        for (int i = index; i < end; i++) {
                result.add(list.get(i));
         }
    }
    return result;
}