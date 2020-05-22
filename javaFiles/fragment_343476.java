public void replaceKeysChar(char originalChar, char newChar, Map<String, ?> map) {
    Map<String, Object> tempMap = new HashMap<String, Object>();
    Set<String> tempSet = new HashSet<String>();
    for (Map.Entry<String, ?> entry : map.entrySet()) {
        String originalKey = entry.getKey();
        String newKey = originalKey .replace(originalChar, newChar);
        if (!newKey.equals(originalKey)) {
            if (map.containsKey(newKey) || tempMap.containsKey(newKey)) {
                throw new CollisionException(newKey);
            }
            tempMap.put(newKey, entry.getValue());
            tempSet.add(originalKey());
        }
    }
    map.keySet().removeAll(tempSet);
    map.putAll(tempMap);
}