// For each (name, quantity) pair
if (nameToQuantityMap.containsKey(name) ) {
    Integer sum = nameToQuantityMap.get(name) + quantity;
    nameToQuantityMap.put(name, sum);
}
else {
        nameToQuantityMap.put(name, quantity);
}