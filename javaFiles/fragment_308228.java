Map<Integer, List<Integer>> adj = new HashMap<>();

public void addEdge(int source, int destination) {
    List<Integer> list = new ArrayList<>();
    adj.put(source, list);
    list.add(destination);
    for (final Entry<Integer, List<Integer>> entry : adj.entrySet()) {
        if (source != entry.getKey()) {
            entry.getValue().add(destination);
        }
    }
}