// if no key is present
if (!map.containsKey(key)) {
    // add key value pair
    map.put(key, value);
} else {
    // get the current list out of the map
    // and merge it with the new one
    map.get(key).addAll(value);
}