boolean hasElement(int elem) {
    return this.elem == elem || (next != null && next.hasElement(elem));
}

boolean hasAllElements(Node node1, Node node2) {
    return node2.hasElement(node1.elem) && (next == null || hasAllElements(next, node2));
}