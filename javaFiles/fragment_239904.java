Map<Integer, String> map = new LinkedHashMap<>();

    map.put(1, "Value");
    if (map.containsKey(1)) {
        throw new Exception("Map already contains key 1");
    }