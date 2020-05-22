class CountVisitor<T> implements Visitor<T> {
    int limit;
    Node<T> node;

    public CountVisitor(int limit) {
        this.limit = limit;
    }

    public boolean accept(Node<T> node) {
        if(--limit == 0) {
            this.node = node;
            return true;
        }
        return false;
    }

    public Node<T> getNode() {
        return node;
    }
}

CountVisitor<T> visitor = new CountVisitor<>(10);
if(treeRoot.visit(visitor)) {
    System.out.println("Node#10 is "+visitor.getNode());
} else {
    System.out.println("Tree has less than 10 nodes");
}