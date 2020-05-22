Map<Integer, Collection<Integer>> adj = new HashMap<>();

public void addEdge(int source, int destination) {
    if (adj.get(source) == null) {
        adj.put(source, new LinkedHashSet<>());

    }
    for (final Entry<Integer, Collection<Integer>> entry : adj.entrySet()) {
        entry.getValue().add(destination);
    }
}