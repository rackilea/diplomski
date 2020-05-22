public static int getDegree(Graph graph, int vertex) throws WrapperException {
    int result;
    try {
        result = graph.returnAdjVertices(vertex).size();
    } catch (VertexOutOfBoundsException e) {
        throw new WrapperException();
    }
    return result;
}