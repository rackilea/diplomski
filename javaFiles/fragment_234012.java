private static final Graph.Edge[] buildData()
{
    Graph.Edge[] GRAPH = { 
        new Graph.Edge("A", "B", 5),
        new Graph.Edge("C", "D", 7), 
        new Graph.Edge("E", "F", 3),
        new Graph.Edge("G", "H", 2), 
        new Graph.Edge("B", "C", 1),
        new Graph.Edge("D", "E", 9), 
        new Graph.Edge("A", "H", 4),
        new Graph.Edge("G", "B", 6) 
    };

    return GRAPH;
}