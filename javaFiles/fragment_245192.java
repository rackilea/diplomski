Graph<String,String> graph = new GraphImpl<>();
        Vertex<String> a = graph.insertVertex("a");
        Vertex<String> b = graph.insertVertex("b");
        Vertex<String> c = graph.insertVertex("c");
        Vertex<String> d = graph.insertVertex("d");
        graph.insertEdge(a, b, "ab");
        graph.insertEdge(a, c, "ac");
        graph.insertEdge(a, d, "ad");