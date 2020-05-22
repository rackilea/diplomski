public boolean isPath(Graph graph, Node start, Node target) {
    for (Node node : graph.getNode()) {
        if (node != null) {
            node.state = State.Unvisited;
        }
    }

    dfs(start);

    return target.state == State.Visited;
}