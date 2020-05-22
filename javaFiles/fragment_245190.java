for (Vertex<V> v : graph.vertices()) {
        //vertex v diferent vertex origin
        if (v.element().equals(origin.element()) != true) {
            //distance [v] = Infinite;
            distances.put(v, Integer.MAX_VALUE);
        } //Q = all vertices of graph;
        Q.add(v);
    }
    //distance [source] = 0;
    distances.put(origin, 0);