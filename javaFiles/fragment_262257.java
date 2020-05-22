Map<String, String> realMap = new HashMap<String, String>();
realMap.put("A", "B");

Map<String, String> unmodifiableMap = Collections.unmodifiableMap(realMap);

// This is not possible: It would throw an 
// UnsupportedOperationException
//unmodifiableMap.put("C", "D");

// This is still possible:
realMap.put("E", "F");

// The change in the "realMap" is now also visible
// in the "unmodifiableMap". So the unmodifiableMap
// has changed after it has been created.
unmodifiableMap.get("E"); // Will return "F".