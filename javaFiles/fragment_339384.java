Map<Integer, List<Object>> map = new TreeMap<>();
for (List<Object> objects : firstList) {
    for (int i = 0, l = objects.size(); i < l; i++) {
        map.computeIfAbsent(i, k -> new ArrayList<>()).add(objects.get(i));
    }
}