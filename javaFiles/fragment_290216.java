Map<Integer, Integer> map = new HashMap<>();
List<Data> filtered = new ArrayList<>();
for (Data data : container) {
    int count = map.merge(data.get_x(), 1, Integer::sum);
    if (count < 3) {
        filtered.add(data);
    }
}