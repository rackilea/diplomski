public class Graph {
    private int numVertex;
    private boolean[][] adj;

    public Graph(int numVertex, int numEdges) {
        this.numVertex = numVertex;
        this.adj = new boolean[numVertex][numVertex];
    }

    public void addEdge(int start, int end){
        adj[start-1][end-1] = true;
        adj[end-1][start-1] = true;
    }

    List<Integer> visited = new ArrayList<Integer>();
    public void DFS(Graph G, int startVertex){
        int i=0;
        pilha.push(startVertex);

        while (!pilha.empty()) {
            int v = pilha.peek();
            Boolean hasNeighbor = false;
            for (i = 1; i <= G.numVertex; i++) {
                if(G.adj[i-1][v-1] != false) {
                    hasNeighbor = true;
                    pilha.push(i);
                    G.adj[i-1][v-1] = false;
                    G.adj[v-1][i-1] = false;
                    break;
                }
            }
            if (!hasNeighbor) {
                visited.add(0, pilha.pop());
            }
        }
        System.out.println("Path: " + visited);
    }

    Stack<Integer> pilha = new Stack<Integer>();

    public static void main(String[] args) {
        Graph g = new Graph(6, 9);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(4, 2);
        g.addEdge(2, 1);
        g.DFS(g, 1);    
    }
}