g = new UndirectedSparseGraph<Long, String>();
    // add some vertices
    for(long i=0;i<5;i++){
        g.addVertex(i);
    }
    // add some edges
    g.addEdge("0-1", 0l, 1l, EdgeType.UNDIRECTED);
    g.addEdge("0-2", 0l, 2l, EdgeType.UNDIRECTED);
    g.addEdge("1-3", 1l, 3l, EdgeType.UNDIRECTED);
    g.addEdge("3-4", 3l, 4l, EdgeType.UNDIRECTED);
    alg = new DijkstraDistance<Long, String>(g);
    for(Long n:g.getVertices()){
        for(Long m:g.getVertices()){
            System.out.println(n+"-"+m+" dist "+alg.getDistance(n, m));
        }
    }
    System.out.println("TOPA\n\n\n");
    g.addEdge("2-4", 2l, 4l, EdgeType.UNDIRECTED);
    alg.reset(2l);
    for(Long n:g.getVertices()){
        for(Long m:g.getVertices()){
            System.out.println(n+"-"+m+" dist "+alg.getDistance(n, m));
        }
    }