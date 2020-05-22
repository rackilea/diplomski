for (String vertexId : u.neighbours.keySet()) { // see neighbours of
                                                        // vertex extracted
        int vertexNum = indexForName(G, vertexId);

        Vertex v = G.vertexes[vertexNum];
        int w = weightFunc(G, u, v);

        relax(u, v, w);
        Q.add(v);
    }