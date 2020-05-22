Map<Vertex, List<Vertex>> mGraph = new ConcurrentHashMap<Vertex,List<Vertex>>();

for (Vertex vertex : mGraph.keySet()){
    List<Vertex> adjacentVertices = mGraph.computeIfAbsent(vertex, this::createAdj);
    //adjacentVertices now contains my initialized list, so do something
}