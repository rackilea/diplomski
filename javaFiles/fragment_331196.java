Map<Double, Map<String, Double>> result = new HashMap<>();
for (Entry<String, Double> mapping : map.entrySet()) {
    Double value = mapping.getValue();
    if (!result.containsKey(value)) {
        result.put(value, new HashMap<>());
    }
    // Add new pair to map
    result.get(value).put(mapping.getKey(), value);
}