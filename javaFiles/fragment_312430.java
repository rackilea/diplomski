import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public  final class Graph {
    private static final class Edge {
        final String name;
        final int weight;
        Edge(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return this.name + ":" + this.weight;
        }
    }
    private static final class Node {
        final String name;
        Map<Node, Edge> edges = new HashMap<>();
        Node[] path;
        int pathWeight;
        Node(String name) {
            this.name = name;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addEdge(String sourceName, String destinationName, int weight, String edgeName) {
        Node source = this.nodes.computeIfAbsent(sourceName, Node::new);
        Node dest = this.nodes.computeIfAbsent(destinationName, Node::new);
        Edge edge = new Edge(edgeName, weight);
        source.edges.put(dest, edge);
        dest.edges.put(source, edge);
    }

    public void startAt(String startNodeName) {
        this.nodes.values().forEach(n -> n.path = null);
        Node source = this.nodes.computeIfAbsent(startNodeName, Node::new);
        source.path = new Node[] { source };
        source.pathWeight = 0;
        TreeSet<Node> pending = new TreeSet<>((a, b) -> Integer.compare(a.pathWeight, b.pathWeight));
        pending.add(source);
        while ((source = pending.pollFirst()) != null) {
            for (Entry<Node, Edge> edge : source.edges.entrySet()) {
                Node dest = edge.getKey();
                int weight = source.pathWeight + edge.getValue().weight;
                if (dest.path == null || weight < dest.pathWeight
                                      || (weight == dest.pathWeight && source.path.length + 1 < dest.path.length)) {
                    if (dest.path != null)
                        pending.remove(dest);
                    dest.path = Arrays.copyOf(source.path, source.path.length + 1);
                    dest.path[source.path.length] = dest;
                    dest.pathWeight = weight;
                    pending.add(dest);
                }
            }
        }
    }

    public String getPath(String endNodeName) {
        Node node = this.nodes.get(endNodeName);
        if (node == null || node.path == null)
            return "Unreachable";
        String path = Arrays.stream(node.path).map(n -> n.name).collect(Collectors.joining(" - "));
        String pathEdges = IntStream.range(1, node.path.length)
                .mapToObj(i -> node.path[i - 1].edges.get(node.path[i]).toString())
                .collect(Collectors.joining(" + "));
        return path + " (distance: " + node.pathWeight + " = " + pathEdges + ")";
    }
}