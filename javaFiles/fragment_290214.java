Map<Integer, List<Data>> map = new HashMap<>();
for (Data data : container) {
    List<Data> value = map.get(data.get_x());
    if (value == null) {
        map.put(data.get_x(), new ArrayList<>(Arrays.asList(data)));
    } else if (value.size() < 3) {
        value.add(data);
    }
}