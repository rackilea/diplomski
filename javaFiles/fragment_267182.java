Map<String, Map<String, Double>> result = new LinkedHashMap<>();
data.forEach(entry -> {
    String name = (String) entry.get("name");
    Map<String, Double> map = result.computeIfAbsent(name, k -> new HashMap<>());
    map.merge("old", (Double) entry.get("old"), Double::sum);
    map.merge("new", (Double) entry.get("new"), Double::sum);
});