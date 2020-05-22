import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.VertexFactory;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class BipartiteGraphTest
{
    public static void main(String[] args)
    {
        UndirectedGraph<String, DefaultEdge> graph =
            new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        VertexFactory<String> vertexFactory = new VertexFactory<String>()
        {
            int n = 0;
            @Override
            public String createVertex()
            {
                String s = String.valueOf(n);
                n++;
                return s;
            }
        };
        int numVertices0 = 10;
        int numVertices1 = 15;
        int numEdges = 20;
        generateGraph(graph, numVertices0, numVertices1, numEdges, vertexFactory);

        System.out.println(graph);
    }

    // Creates a bipartite graph with the given numbers 
    // of vertices and edges
    public static <V, E> void generateGraph(Graph<V, E> graph,
        int numVertices0, int numVertices1, int numEdges,
        final VertexFactory<V> vertexFactory)
    {
        List<V> vertices0 = new ArrayList<V>();
        for (int i = 0; i < numVertices0; i++)
        {
            V v = vertexFactory.createVertex();
            graph.addVertex(v);
            vertices0.add(v);
        }
        List<V> vertices1 = new ArrayList<V>();
        for (int i = 0; i < numVertices1; i++)
        {
            V v = vertexFactory.createVertex();
            graph.addVertex(v);
            vertices1.add(v);
        }

        // Create edges between random vertices
        Random random = new Random(0);
        while (graph.edgeSet().size() < numEdges)
        {
            int i1 = random.nextInt(vertices1.size());
            V v1 = vertices1.get(i1);
            int i0 = random.nextInt(vertices0.size());
            V v0 = vertices0.get(i0);
            graph.addEdge(v0, v1);
        }

    }

    // Creates a bipartite graph with the given numbers
    // of vertices and edges without isolated vertices
    public static <V, E> void generateGraphNoIsolatedVertices(
        Graph<V, E> graph, int numVertices0, int numVertices1, int numEdges,
        final VertexFactory<V> vertexFactory, 
        List<V> vertices0, List<V> vertices1)
    {
        int minNumEdges = Math.max(numVertices0, numVertices0);
        if (numEdges < minNumEdges)
        {
            System.out.println("At least " + minNumEdges + " are required to " +
                "connect each of the " + numVertices0 + " vertices " +
                "to any of the " + numVertices1 + " vertices");
            numEdges = minNumEdges;
        }

        for (int i = 0; i < numVertices0; i++)
        {
            V v = vertexFactory.createVertex();
            graph.addVertex(v);
            vertices0.add(v);
        }
        for (int i = 0; i < numVertices1; i++)
        {
            V v = vertexFactory.createVertex();
            graph.addVertex(v);
            vertices1.add(v);
        }

        // Connect each vertex of the larger set with
        // a random vertex of the smaller set
        Random random = new Random(0);
        List<V> larger = null;
        List<V> smaller = null;


        if (numVertices0 > numVertices1)
        {
            larger = new ArrayList<V>(vertices0);
            smaller = new ArrayList<V>(vertices1);
        }
        else
        {
            larger = new ArrayList<V>(vertices1);
            smaller = new ArrayList<V>(vertices0);
        }
        List<V> unmatched = new ArrayList<V>(smaller);
        for (V vL : larger)
        {
            int i = random.nextInt(unmatched.size());
            V vS = unmatched.get(i);
            unmatched.remove(i);
            if (unmatched.size() == 0)
            {
                unmatched = new ArrayList<V>(smaller);
            }
            graph.addEdge(vL, vS);
        }

        // Create the remaining edges between random vertices
        while (graph.edgeSet().size() < numEdges)
        {
            int i0 = random.nextInt(vertices0.size());
            V v0 = vertices0.get(i0);
            int i1 = random.nextInt(vertices1.size());
            V v1 = vertices1.get(i1);
            graph.addEdge(v0, v1);
        }

    }


}