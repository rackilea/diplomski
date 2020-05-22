public Map<String, List<Data>> convert(Map<Long, Map<String, Data>> array) {
    Map<String, List<Data>> result = new HashMap<String, List<Data>>();
    for (Map<String, Data> inter : array.values()) {
        for (Map.Entry<String, Data> entry : inter.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (!result.containsKey(k)) {
                result.put(k, new ArrayList<Data>());
            }
            result.get(k).add(v);      
        }
    }
    return result;
}