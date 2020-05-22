public <T> List<T> canonicalizeList(List<T> input) {
    HashMap<T, T> map = new HashMap<>();
    List<T> output = new ArrayList<>();
    for (T element: input) {
        T canonical = map.get(element);
        if (canonical == null) {
            element = canonical;
            map.put(canonical, canonical);
        }
        output.add(canonical);
    }
    return output;
}