TreeMap<Integer, Set<String> > treeMap = new TreeMap<Integer, Set<String> > ();
for (Map.Entry<String, Integer> entry: hashMap) {
    Set<String> set = treeMap.get(entry.value());
    if (set == null) {
        set = new TreeSet<String>();
        treeMap.put(entry.value(), set);
    }
    set.add(entry.key());
}