int id = 0;
Map<Integer, String> edgeData = new HashMap<>();
while((line = in.readLine()) != null) {
    graph.addNode(new Node(id));
    put(id, line);
}
edgeData.entrySet().stream()
    .forEach(entry -> graph.addEdge(entry.getKey(), entry.getValue());