// we need to store the keys, then get the values in common, then put the key/map into map
public static Map<String, Integer> intersect(Map<String, Integer> first, Map<String, Integer> second) {
    Map<String, Integer> output = new HashMap<String, Integer>(); // combined output

    // goes through each key in common and checks to see if they reference to the same value    
    Iterator<String> keyFirstItr = first.keySet().iterator();
    while (keyFirstItr.hasNext()) {
        String keyTemp = keyFirstItr.next();
        if (first.get(keyTemp).equals(second.get(keyTemp))) { // If same key, same value mapped
            output.put(keyTemp, first.get(keyTemp)); // add key value to map
        }
    }
    return output;
}