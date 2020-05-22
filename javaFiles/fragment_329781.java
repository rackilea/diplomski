Map<Integer, Set<Integer>> result = new TreeMap<Integer, Set<Integer>>();

public void parseInput(int key, int value) {
    if(result.get(key) == null) { // if you have not encountered the first integer yet, add it to your map.
        result.put(key, new TreeSet<Integer>() {{ add(value); }});
    } else { // otherwise, just add your value to your existing set. The set will take care of duplicates.
        result.get(key).add(value);
    }
}