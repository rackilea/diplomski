boolean found = 
    nMap.entrySet()
        .stream()
        .anyMatch(e -> !mMap.containsKey(e.getKey()) || mMap.get(e.getKey()) < e.getValue());
if (found)
    return -1;