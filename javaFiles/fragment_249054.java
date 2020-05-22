public class CustomGraph extends SimpleWeightedGraph<Node, DefaultWeightedEdge>{

    /**
     * Creates a new simple weighted graph with the specified edge factory.
     *
     * @param ef the edge factory of the new graph.
     */
    public CustomGraph(EdgeFactory<Node, DefaultWeightedEdge> ef)
    {
        super(ef);
    }

    /**
     * Creates a new simple weighted graph.
     *
     * @param edgeClass class on which to base factory for edges
     */
    public CustomGraph(Class<? extends DefaultWeightedEdge> edgeClass)
    {
        this(new ClassBasedEdgeFactory<Node, DefaultWeightedEdge>(edgeClass));
    }

}