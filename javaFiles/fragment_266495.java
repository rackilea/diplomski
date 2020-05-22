public static Map.Entry<String, Integer> findLowest(Map<String, Integer> map) {
    Map.Entry<String, Integer> result = null;
    if (map != null && !map.isEmpty()) {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        result = it.next();
        while (it.hasNext()) {
            Map.Entry<String, Integer> current = it.next();
            if (current.getValue() < result.getValue()) {
                result = current;
            }
        }
    }
    return result;
}