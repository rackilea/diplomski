enum IdentitySort implements Comparator<Node> {
    INSTANCE;

    @Override
    public int compare(Node n1, Node n2) {
        return Integer.compare(System.identityHashCode(n1),
                               System.identityHashCode(n2));
    }
}