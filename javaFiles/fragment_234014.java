public static void main_forloop(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Graph.Edge[] GRAPH = new Graph.Edge[n];

    for(int i = 0; i < n; i++) {
        GRAPH[i] = 
            new Graph.Edge(sc.next(),sc.next(),sc.nextInt());
    }

    String START = sc.next();
    String END = sc.next();
    Graph g = new Graph(GRAPH);

    g.dijkstra(START);
    // print the shortest path using Dijkstra algorithm
    g.printPath(END);
    // g.printAllPaths();

    sc.close();
    sc = null;
}