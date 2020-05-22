Map<LinkedList<Integer>, Set<String>> mapInverted = new HashMap<>(myMap.size());
for(Entry<<String, LinkedList<Integer>> entry : myMap.entrySet()) {
    String key = entry.getKey();
    LinkedList<Integer> list = entry.getValue();
    Set<String> strings = mapInverted.get(list);
    if(strings == null) { // the list has not already been put in the map
        strings = new HashSet<String>(); // create a new set
        mapInverted.put(list, strings); // put the list and the new set
    }
    strings.add(key);
}