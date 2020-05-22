Map<String, Deque<String>> myMap = new ConcurrentHashMap<>();

// Add new key/value pair
String key = "catKey";
String value = "catValue1";
myMap.computeIfAbsent(key, k -> new ConcurrentLinkedDeque<>()).add(value);