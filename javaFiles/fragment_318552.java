Set<String> seenValues = new HashSet<String>();
Map<String, String> result = new HashMap<String, String>();

for (Map.Entry<String, String> entry : original.entrySet()) {
    String value = entry.getValue();

    if (seenValues.contains(value)) {
        value = ...; // update value here
    }
    result.put(entry.getKey(), value);
    seenValues.add(value);
}