private void performRecursiveDFS(MazeGraph mazeGraph, int node, int goal) {
    visited[node] = true; //set visited
    for (int arc : mazeGraph.getAdjacencyList(node)) {
        if (!visited[arc]) {
            pathTo[arc] = node;
            performRecursiveDFS(mazeGraph, arc, goal);

        }
    }
    visited[node] = false; //unset visited
}