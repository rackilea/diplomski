public static Map<Point, Set<Point>> createTraversalMap(List<Pair<Point, Point>> relationshipList) {
    Map<Point, Set<Point>> traversalMap = new HashMap<Point, Set<Point>>();
    for (Pair<Point, Point> relationship : relationshipList) {
        Point fromVertex = relationship.getLeft(), toVertex = relationship.getRight();
        Set<Point> toSet = traversalMap.get(fromVertex);// set of Vertexes we've found so far for the current "from" Vertex
        if (toSet == null) {// bootstrap the set
            toSet = new HashSet<Point>();
            traversalMap.put(fromVertex, toSet);
        }
        toSet.add(toVertex);
        // traversalMap.put(fromVertex, toSet); //not needed, but good to keep in mind
    }
    return traversalMap;
}