private Node fetchChildren(Node parent) {
    Hibernate.initialize(parent.getChildren());
    for (Node child : parent.getChildren()) {
        fetchChildren(child);
    }
    return parent;
}