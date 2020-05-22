DirectedGraph<Integer, DefaultEdge> g =
        new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);

    Integer v1 = 2367;
    Integer v2 = 56799;
    Integer v3 = 78678;
    Integer v4 = 343;

    // add the vertices
    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);
    g.addVertex(v4);

    // add edges to create a circuit
    g.addEdge(v1, v2);
    g.addEdge(v2, v3);
    g.addEdge(v3, v4);
    g.addEdge(v4, v1);

    //Print out the graph to be sure it's really complete
    Iterator<Integer> iter =
        new DepthFirstIterator<Integer, DefaultEdge>(g);
    Integer vertex;
    while (iter.hasNext()) {
        vertex = iter.next();
        System.out.println(
            "Vertex " + vertex + " is connected to: "
            + g.edgesOf(vertex));
    }