public void addEdge(int source, int destination) {
    if (adj.get(source) == null) {
        adj.put(source, new ArrayList<>());

    }
    for (final Entry<Integer, List<Integer>> entry : adj.entrySet()) {
        entry.getValue().add(destination);
    }
}