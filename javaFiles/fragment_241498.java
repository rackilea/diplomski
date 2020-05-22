public <T> ArrayList<T> filterList(List<? super T> list, Class<T> subClass) {
    ArrayList<T> result = new ArrayList<>();
    for (Object obj : list) {
        if (subClass.isInstance(obj)) {
            result.add((T) obj);
        }
    }
    return result;
}