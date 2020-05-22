final Map<String, List<String>> map = new HashMap<>();
String lastKey = null;
for (String item: list) {
    if (item.startsWith("src")) {
        map.putIfAbsent(item, new ArrayList<>());
        lastKey = item;
    } else {
        map.get(lastKey).add(item);
    }
}