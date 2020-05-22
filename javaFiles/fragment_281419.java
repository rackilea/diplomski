public void addToMappedList(Map<String, List<Integer>> map,
                                 String key, Integer value) {
    List<Integer> existingValues = map.get(key);
    if (existingValues == null) {
        existingValues = new ArrayList<Integer>();
        map.put(key, existingValues);
    }
    existingValues.add(value);
}

addToMappedList(map, "foo", 1);
addToMappedList(map, "foo", 2);