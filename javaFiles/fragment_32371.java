static <T extends Comparable<T>> LinkedHashMap<T, Integer> sortNumberHashMapByKey(HashMap<T, Integer> map){
    ArrayList<T> keys = new ArrayList<>(map.keySet());
    ArrayList<Integer> values = new ArrayList<>(map.values());
    Collections.sort(keys);
    Collections.sort(values);
    LinkedHashMap<T, Integer> sortedMap = new LinkedHashMap<>();

    for (Integer value : values) {
        Iterator<T> keyIt = keys.iterator();
        while (keyIt.hasNext()){
            T key = keyIt.next();
            if (map.get(key).equals(value)){
                keyIt.remove();
                sortedMap.put(key, value);
                break;
            }
        }
    }
    return sortedMap;
}