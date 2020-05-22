// setup a map of oldValue to newValue
HashMap<String, Integer> valueMap = ...;
int i = 0;
for (String oldValue : data.values()) {
    if ( ! valueMap.contains(oldValue )) {
        valueMap.put(oldValue, ++i);
    }
}

// replace everything in data
for (Map.Entry<Integer, String> dataEntry : data.entrySet()) {
    finalMap.put(dataEntry.getKey(), valueMap.get(dataEntry.getValue());
}