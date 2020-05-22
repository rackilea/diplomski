public class Graph {
    private final Iterable<Edge> allNodes;

    public Graph(Iterable<Edge> allNodes) {
        this.allNodes = allNodes;
    }

    public List<Edge> edgesFrom(int vertex) {
        List<Edge> filteredNodes = new ArrayList<Edge>();
        for (Edge node : allNodes) {
            if (node.source == vertex || node.next == vertex) {
                filteredNodes.add(node);
            }
        }
        return filteredNodes;
    }

    public List<List<Edge>> allPaths(int source, int dest) {
        List<Edge> path = new ArrayList<>();
        List<List<Edge>> allPaths = new ArrayList<>();
        for (Edge n: edgesFrom(source)) {
            searchPaths(n, source, dest, path, allPaths);
        }            
        return allPaths;
    }

    private void searchPaths(Edge n, int source, int dest, List<Edge> path,
            List<List<Edge>> allPaths) {
        path.add(n); //local path to be listed
        int next = n.source == source ? n.next : n.source;
        List<Edge> neighbors = edgesFrom(next); //function to get node neighbors
        if (next == dest) {
            allPaths.add(new ArrayList<>(path)); //all paths to be listed
        }
        for (Edge nNode : neighbors) {
            if (!path.contains(nNode)) {
                searchPaths(nNode, next, dest, path, allPaths);
            }
        }
        path.remove(n);
    }
}