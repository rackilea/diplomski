public static Graph karyTree(Graph g, int V, int k) {
    int[] vertices = new int[(int)Math.pow(V, k)];
    for (int i = 0; i < (int)Math.pow(V, k); i++) vertices[i] = i;
    for (int i = 1; i < (int)Math.pow(V, k); i++) {
        g.addEdge("ax" + returnRandom(0,100000000), "a"+vertices[i],"a"+vertices[(i-1)/k]);
    }
    return g;
}