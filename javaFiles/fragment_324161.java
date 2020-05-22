public void dfs(Node node) {
    if (node == null) {
        return;
    }

    System.out.println("Node: " + node.getVertex());
    node.state = State.Visited;

    for (Node n : node.getAdjacent()) {
        if (n.state != State.Visited) {
            dfs(n);
        }
    }
}