public static int getDegree(Graph graph, int vertex) {
    int result;
    try {
        result = graph.returnAdjVertices(vertex).size();
    } catch (VertexOutOfBoundsException e) {
        result = fixGraphAndReturnAdjVertices(graph, vertex);
    }
    return result;
}