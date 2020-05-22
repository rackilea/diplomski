public static void main_build(String[] args) {
    String START = "A";
    String END = "G";
    Graph.Edge[] GRAPH = buildData();
    Graph g = new Graph(GRAPH);

    g.dijkstra(START);
    // print the shortest path using Dijkstra algorithm
    g.printPath(END);
    //g.printAllPaths();
}

public static void main_input(String[] args) {
    Scanner sc = new Scanner(System.in);
    //int n = sc.nextInt();
    //
    Graph.Edge[] GRAPH = { 
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()),
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()), 
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()),
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()), 
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()),
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()), 
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()),
        new Graph.Edge(sc.next(), sc.next(), sc.nextInt()) 
    };

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