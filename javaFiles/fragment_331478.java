Map map = new HashMap();

// [...] fill the map

List keys = new ArrayList(map.keySet());
Collections.shuffle(keys);
for (Object o : keys) {
    // Access keys/values in a random order
    map.get(o);
}