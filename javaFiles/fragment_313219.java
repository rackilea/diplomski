public void add(String outerKey, String innerKey, Integer value) {
    Map<String, Integer> tempMap
    if (outerMap.containsKey(outerKey)) {
        tempMap = outerMap.get(outerKey);
    } else {
        tempMap = new HashMap<String, Integer>();
        outerMap.put(outerKey, tempMap);
    }
    tempMap.put(innerKey, value);
}