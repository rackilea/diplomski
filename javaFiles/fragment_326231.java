public double getPathWeight(List<VertexType> path) throws GraphPathException {
    VertexType previousVertex = path.get(0);

    double resultWeight = 0.0;
    for (int i = 1; i < path.size(); i++) {
        VertexType currentVertex = path.get(i);
        Map<VertexType, Double> adjacencyForPreviousVertex = adjacency.get(previousVertex);
        if (adjacencyForPreviousVertex == null) {
            throw new GraphPathException("Vertex " + previousVertex + " don't exist in graph");
        }
        Double currentEdgeWeight = adjacencyForPreviousVertex.get(currentVertex);
        if (currentEdgeWeight == null) {
            throw new GraphPathException(currentVertex + "Vertex don't exist as an adjacent Vertex of " + previousVertex);
        }
        resultWeight += currentEdgeWeight;
        previousVertex = currentVertex;
    }
    return resultWeight;
}