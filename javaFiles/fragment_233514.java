HashMap<String, Set<String>> hmap = new HashMap<>();
Set<String> val = hmap.get(key);
if (val == null) {
    val = new HashSet<>();
    val.add(newElement);
    hmap.put(key, val);
}
else {
    val.add(newElement);
}