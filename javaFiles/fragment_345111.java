public <T> Map<T, Integer> doSomething(Map<T, Integer> map, Integer total) {
    Map<T, Integer> result = new HashMap<T, Integer>();
    for (T key : map.keySet()) {
        result.put(key, map.get(key) * 2);
    }
    return result;
}