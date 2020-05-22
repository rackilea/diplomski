public static boolean dfs2(int[][] graph, boolean[] visited, int startNode, int targetNode) {

    // if you have not visited the current node or the target node
    // then visit this node and recursively explore its unvisited 
    //neighbors
    if (!visited[startNode] && !visited[targetNode]) {
        // visit the start node
        visited[startNode] = true;
        for (int i = 0; i < graph[startNode].length; i++) {
            if (graph[startNode][i] == 1) {
                return dfs(graph, visited, i, targetNode);
            }
        }
    }
    // otherwise we just return whether or not we have visited the
    // target node and continue... If we have visited the target node 
    //we never go into the if-statement and we always return true

    return visited[targetNode];

}