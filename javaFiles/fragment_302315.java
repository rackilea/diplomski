Graph graph = new Graph(Arrays.asList(
        new Edge(1,2), new Edge(2,3), new Edge(3,4), new Edge(1,4)));
List<List<Edge>> allPaths = graph.allPaths(1,3);
for (List<Edge> path: allPaths) {
    System.out.println(path);
}