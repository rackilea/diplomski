public class Graph {


    private Collection<Edge> edges;
    private Collection<Node> nodes;
    public Collection<Edge> getEdges() {
        return edges;
    }
    public void setEdges(Collection<Edge> edges) {
        this.edges = edges;
    }
    public Collection<Node> getNodes() {
        return nodes;
    }
    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }
    public Graph(Collection<Edge> edges, Collection<Node> nodes) {
        super();
        this.edges = edges;
        this.nodes = nodes;
    }



}

    Graph g = new Graph(edges, nodes); 

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(g);

    return json;