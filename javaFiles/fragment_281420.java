public boolean removeFromMappedList(Map<String, List<Integer>> map,
                                         String key, Integer value) {
    List<Integer> existingValues = map.get(key);
    if (existingValues != null) {
        return existingValues.remove(value);
    }
    return false;
}

removeFromMappedList(map, "foo", 1); // true
removeFromMappedList(map, "foo", 3); // false