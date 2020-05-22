import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.KruskalMinimumSpanningTree;

public class MyGraph {

    private UndirectedGraph<String, DefaultEdge> g = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    static final double DEFAULT_EDGE_WEIGHT=19;
    DefaultWeightedEdge>(DefaultWeightedEdge.class); 
    private DefaultWeightedEdge e1;

    public void addVertex(String name) {
        g.addVertex(name);
        //graph.addVertex(name);
    }

    public void addEdge(String v1,String v2) {
        g.addEdge(v1, v2);
        // e1=graph.addEdge(v1, v2);
    }

    /*public void setEdgeWeight() {
        graph.setEdgeWeight(e1, DEFAULT_EDGE_WEIGHT);          
    }*/

    public UndirectedGraph<String, DefaultEdge> getGraph() {
        return g;
    }

    /*public SimpleWeightedGraph<String,DefaultWeightedEdge> getGraph() {
        return graph;
    }*/

    public void getSpanningTree() {
        KruskalMinimumSpanningTree k=new KruskalMinimumSpanningTree(g);
        System.out.println(k.getEdgeSet().toString());
        //KruskalMinimumSpanningTree k1=new KruskalMinimumSpanningTree(graph);
        //System.out.println(k1.getEdgeSet().toString());   
    }

    /*public void getSpanningTreeCost() {
        KruskalMinimumSpanningTree k=new KruskalMinimumSpanningTree(graph);
        System.out.println(k.getSpanningTreeCost());
    }*/ 
}