protected Node getTrueParent() {
    for (Edge e : this.edges) {
        if (e.getNode2() == this && (!e.isPseudo())) {
            Node parent = e.getNode1();
            return parent;
        }
    }
    return null; // ADD THIS
}