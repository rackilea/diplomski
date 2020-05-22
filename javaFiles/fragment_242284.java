TreeMap<String, List<String>> treeMap3 = new TreeMap<>(treeMap1);
for (String k : treeMap3.keySet()) {
    if (treeMap2.containsKey(k)) {
        treeMap3.get(k).addAll(treeMap2.get(k));
    }
} 
return treeMap3;