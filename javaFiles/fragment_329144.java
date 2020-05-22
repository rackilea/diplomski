public class DFSearch extends IterationSearch implements GraphSearch{
    @Override
    public Node search(Graph g, Node n) {
        return search(g, n, new DFSIterator(g));
    }
}