Map<Integer, List<Data>> map = new HashMap<>();
for (Data data : container) {
    List<Data> list = map.computeIfAbsent(data.get_x(), k -> new ArrayList<Data>());
    if (list.size() < 3) {
        list.add(data);
    }
}