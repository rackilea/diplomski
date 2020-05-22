import java.util.List;

public class ImmutableGraph<G> {
Node<G> selectedNode;

private ImmutableGraph(Node<G> initialNode) {
    selectedNode = initialNode;
}

// many more things

public static class GraphBuilder<B> {
    Node<B> currentNode;

    public GraphBuilder(B value) {
        currentNode = new Node<B>(value);
    }

    public ImmutableGraph<B> build() {
        return new ImmutableGraph<B>(currentNode);
    }

    // many more things
}

private static class Node<N> {
    private final N value;
    List<Node<N>> neighbours;

    public Node(N v) {
        value = v;
    }

    // many more things
}

public static void main(String[] args) {
    GraphBuilder<Integer> builder = new GraphBuilder<Integer>(Integer.MAX_VALUE);
    ImmutableGraph<Integer> graph = builder.build();
    System.out.println(graph.selectedNode.value);
}
}