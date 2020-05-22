Map<String, Map<String, Employee>> output = new HashMap<>();
tempCollection.forEach((k, v) -> {
    if (v.values().stream().anyMatch(i -> "M".equals(i.getGender()))) {
        output.put(k, v.entrySet()
                .stream()
                .filter(i -> "M".equals(i.getValue().getGender()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
});