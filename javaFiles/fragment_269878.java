public static void main(String[] args) {
    EdgeWeightedDigraph g = new EdgeWeightedDigraph(3);
    DirectedEdge e1 = new DirectedEdge(0, 1, 01.10);
    g.addEdge(e1);
    DirectedEdge e2 = new DirectedEdge(1, 2, 12.21);
    g.addEdge(e2);
    DirectedEdge e3 = new DirectedEdge(2, 0, 20.02);
    g.addEdge(e3);
    System.out.println(g.toString());

    EdgeWeightedDigraph gr = reverse(g);
    System.out.println(gr.toString());
}

private static EdgeWeightedDigraph reverse(EdgeWeightedDigraph g) {
    int numVertices = g.V();
    EdgeWeightedDigraph gr = new EdgeWeightedDigraph(numVertices);
    for (DirectedEdge e : g.edges()) {
        int f = e.from();
        int t = e.to();
        double w = e.weight();
        DirectedEdge er = new DirectedEdge(t, f, w);
        gr.addEdge(er);
    }
    return gr;
}