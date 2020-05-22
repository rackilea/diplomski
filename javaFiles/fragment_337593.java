public class Test {

    public static void main(String[] args) {
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");

        DefaultWeightedEdge e1 = graph.addEdge("1", "2");
        graph.setEdgeWeight(e1, 5);
        DefaultWeightedEdge e2 = graph.addEdge("2", "3");
        graph.setEdgeWeight(e2, 10);
        DefaultWeightedEdge e3 = graph.addEdge("2", "4");
        graph.setEdgeWeight(e3, 2);
        DefaultWeightedEdge e4 = graph.addEdge("4", "5");
        graph.setEdgeWeight(e4, 2);
        DefaultWeightedEdge e5 = graph.addEdge("5", "3");
        graph.setEdgeWeight(e5, 2);

        System.out.println(BFSShortestPath.findPathBetween(graph, "1", "3"));
    }

}

final class BFSShortestPath {

    private BFSShortestPath() {} // ensure non-instantiability.

    public static <V, E> List<E> findPathBetween(Graph<V, E> graph, V startVertex, V endVertex) {
        MyBreadthFirstIterator<V, E> iter = new MyBreadthFirstIterator<>(graph, startVertex);
        while (iter.hasNext()) {
            Object vertex = iter.next();
            if (vertex.equals(endVertex)) {
                return createPath(iter, endVertex);
            }
        }
        return null;
    }

    private static <V, E> List<E> createPath(MyBreadthFirstIterator<V, E> iter, V endVertex) {
        List<E> path = new ArrayList<E>();
        while (true) {
            E edge = iter.getSpanningTreeEdge(endVertex);
            if (edge == null) {
                break;
            }
            path.add(edge);
            endVertex = Graphs.getOppositeVertex(iter.getGraph(), edge, endVertex);
        }
        Collections.reverse(path);
        return path;
    }

    private static class MyBreadthFirstIterator<V, E> extends BreadthFirstIterator<V, E> {

        public MyBreadthFirstIterator(Graph<V, E> g, V startVertex) {
            super(g, startVertex);
        }

        @Override
        protected void encounterVertex(V vertex, E edge) {
            super.encounterVertex(vertex, edge);
            putSeenData(vertex, edge);
        }

        @SuppressWarnings("unchecked")
        public E getSpanningTreeEdge(V vertex) {
            return (E) getSeenData(vertex);
        }

    }
}