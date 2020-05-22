//while (Q is not empty) do,
    while (!Q.isEmpty()) {
        //remove u from Q;
        Vertex<V> u = remove(Q);
        //u = vertex is graph with less distance;
        int distanceU = distances.get(u);
        //if (distance [u] == Infinity)
        for (Edge<E, V> edge : graph.incidentEdges(u)) {
            //for every neighbor v of u
            Vertex<V> v = graph.opposite(u, edge);
            //distance [v]
            int d = distanceU + 1;
            //(d < distance [v])
            if (d < distances.get(v)) {
                //distance [v] = d;
                distances.put(v, d);
                //predecessor [v] = u;
                path.put(v, u);
            }
        }
    }