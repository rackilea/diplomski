Map<Integer, String> map = ... //Your map
Map<String, Set<Integer>> reverseMap = new TreeMap<String, Set<Integer>>();

for(Map.Entry<Integer, String> entry : map.entrySet()) {
    Integer key = entry.getKey();
    String value = entry.getValue();
    Set<Integer> set;

    if(reverseMap.containsKey(value)) {
        set = reverseMap.get(value);
        set.add(key);
    } else {
        set = new HashSet<Integer>();
        set.add(key);
        reverseMap.put(value, set);
    }
}