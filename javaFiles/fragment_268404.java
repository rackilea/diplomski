Map<Integer, String> oldMap; // get oldMap from somewhere
// Prepare remapping
Map<Integer, String> newMap = new TreeMap<Integer, String>();
Map<Integer, Integer> keyMap = new HashMap<Integer, Integer>();
// Store a new key for each old key
keyMap.put(oldKey, newKey);
// fill the newMap
for(Integer oldKey : keyMap.keySet()) {
    newMap.put(keyMap.get(oldKey), oldMap.get(oldKey));
}
oldMap = newMap; // if needed