Set<String> nonField1Values = new HashSet<>();
for (Map.Entry<String, String> entry : myHashMap.entrySet()) {
    if (!entry.getKey().equals("field1")) {
        String currentValue = entry.getValue();
        List<String> values = Arrays.asList(currentValue.split(","));
        nonField1Values.addAll(values);
    }
}