public class Graph<T extends Comparable<T>> {

    private GraphNode<T> root;

    public void insert(T d, GraphNode<T> n) {
        if (root == null && n == null)
            root = new GraphNode<T>(d);
        if (root == null)
            root = n;
        GraphNode<T> node = root;
        Queue<GraphNode<T>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.setNodeColor(color.BLACK);
            if (node.equals(n)) {
                GraphNode<T> newNode = new GraphNode<T>(d);
                ((GraphNode<T>) newNode).setAdjNode(newNode);
            } else {
                queue.addAll(node.getUnexploredAdjNodes());
            }
        }
    }

}
public class GraphNode<T extends Comparable<T>> implements Comparable<GraphNode<T>> {

    enum color {
        WHITE, GREY, BLACK
    };

    private T data;

    private color nodeColor = color.WHITE;

    private LinkedHashSet<GraphNode<T>> adjNodes = new LinkedHashSet<>();

    GraphNode() {
        data = null;
    }

    GraphNode(T d) {
        setData(d);
    }

    public void setAdjNode(GraphNode<T> n) {
        adjNodes.add(n);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedHashSet<GraphNode<T>> getAdjNodes() {
        return adjNodes;
    }

    public LinkedHashSet<GraphNode<T>> getUnexploredAdjNodes() {
        LinkedHashSet<GraphNode<T>> n = new LinkedHashSet<>();
        for (GraphNode<T> node : adjNodes) {
            if (node.getNodeColor() == color.WHITE)
                n.add(node);
        }
        return n;
    }

    public color getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(color nodeColor) {
        this.nodeColor = nodeColor;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GraphNode<?>) {
            return ((GraphNode<?>) obj).getData() == this.getData();
        }
        return false;
    }

    @Override
    public int compareTo(GraphNode<T> o) {
        return data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return data + "";
    }
}
Graph<Integer> graph = new Graph<>();