SortedMap<Integer, String> map = new TreeMap<Integer, String>();
for (int i = 0; i < newIndexes.length; i++) {
    map.put(newIndexes[i], fruits.get(i));
}

Collection<String> sortedFruits = map.values();