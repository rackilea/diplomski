List[] list = new ArrayList[10];
for (int i = 0; i < edges.length; i++) {
    int i1 = edges[i][1];
    int i0 = edges[i][0];
    list[i1].add(i0);
}