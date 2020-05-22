public static Map<Integer, Long> populateMyHashMapFromDB() {
    Map<Integer, Long> map = new LinkedHashMap<Integer, Long>();
    for (int i = 0; i < 10; i++) 
            map.put(getIntFromDB(i), getLongFromDB(i));
    return map;
}

Map<Integer, Long> map = populateMyHashMapFromDB();
Long value = map.get(key);