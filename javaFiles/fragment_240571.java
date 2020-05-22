public ArrayList<Vertex> DFS_Recursive(Vertex start) {
    ArrayList<Vertex> result = new ArrayList<>();
    HashMap<Vertex, Boolean> visited = new HashMap<>();
    for (Vertex v : adjacencyList.keySet()) {
        visited.put(v, false);
    }
    DFS_Recursive_Utility(start, result, visited);
    return result;
}


private void DFS_Recursive_Utility(Vertex vertex,
                                   ArrayList<Vertex> results,
                                   HashMap<Vertex, Boolean> visited) {
        if (vertex == null) {
            return;
        }
        visited.put(vertex, true);
        results.add(vertex);
        for (Vertex v : adjacencyList.get(vertex)) {
            if (!visited.get(v)) {
            DFS_Recursive_Utility(v, results, visited);
        }
    }
}