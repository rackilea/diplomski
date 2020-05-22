Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
for (Map.Entry<Integer, String> e: entrySet) {
    int index;
    if ((index = list.indexOf(e.getValue())) >= 0 && index != e.getKey()) {
        list.set(index, list.set(e.getKey(), e.getValue()));
    }
}