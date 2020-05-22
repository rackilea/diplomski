Map<String, String> fieldNameIndex = new HashMap<>();

void addEntry(Map<String, Object> map, String name, Object value) {
    String existingName = fieldNameIndex.get(name);
    if (existingName == null) {
        fieldNameIndex.put(name, name);
        existingName = name;
    }

    map.put(existingName, value);
}