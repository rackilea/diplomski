class Node {
    private int id;
    private List<Edge> edges;
    public boolean hasId(int id) {
        return id == this.id;
    }
    public addEdge(Node node, int weight) {
        edges.add(new Edge(node, weight));
    }
}

class Edge {
    private int weight;
    private Node destination;
}

class Graph {
    private List<Node> nodes;
    public Node getNodeById(int id) {
        return nodes.stream()
            .filter(node -> node.hasId(id))
            .findFirst().orElse(null);
    }
}