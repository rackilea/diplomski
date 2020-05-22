public Collection<Integer> getOddKeys() {
    // keySet is a method of Map that returns a Set containing all the keys (and no values).
    Collection<Integer> result = new ArrayList<Integer>();
    for(Integer key : map.keySet()) {
        if((key % 2) == 0) // if the key is odd...
            result.add(key); // ... then add it to the result
    }
    return result;
}