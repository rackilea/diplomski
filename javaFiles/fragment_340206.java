public static void main(String[] args) {

    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");

    A.getChildren().addAll(asList(B, D));
    B.getChildren().addAll(asList(C));
    C.getChildren().addAll(asList(F));
    D.getChildren().addAll(asList(B, F, E));
    E.getChildren().addAll(asList(F));
    //F.getChildren().addAll(asList());
    G.getChildren().addAll(asList(F));

    testDFS(F);
    testDFS(G);
    testDFS(A);

}

static class Node {
    private final String label;
    private final List<Node> children;

    Node(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public int hashCode() {
        return getLabel().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node))
            return false;
        return getLabel().equals(((Node) obj).getLabel());
    }
}