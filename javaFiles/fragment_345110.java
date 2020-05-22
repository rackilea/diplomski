public <Sometype> Map<Sometype, Integer> doSomething(
        Map<Sometype, Integer> map, Integer total) {
    Map<Sometype, Integer> result = new HashMap<Sometype, Integer>();
    for (Sometype key : map.keySet()) {
        result.put(key, map.get(key) * 2);
    }
    return result;
}