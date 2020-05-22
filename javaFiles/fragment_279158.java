class Graph {

    private java.util.ArrayList<Node> nodeList;
    private int numberOfNodes;

    public Graph(int size) {
        nodeList = new java.util.ArrayList<Node>(size + 1);
        numberOfNodes = size;

        for (int i = 0; i <= numberOfNodes; i++) {
            nodeList.add(new Node());
        }
    }

    public void addEdge(int a, int b) {
        if (a >= 1 && a <= numberOfNodes) {
            if (b >= 1 && b <= numberOfNodes) {
                nodeList.get(a).addNeighbour(nodeList.get(b));
                nodeList.get(b).addNeighbour(nodeList.get(a));
            }
         }
    }

    public void walk(Node origin, java.util.Set<Node> visited) {
        for (Node n : origin.getNeighbours()) {
            if (!visited.contains(n)) {
                visited.add(n);
                walk(n, visited);
            }
        }
    }

    public boolean hasPath(Node origin, Node target) {
        java.util.Set<Node> reachables = new java.util.HashSet<Node>();
        walk(origin, reachables);
        return reachables.contains(target);
    }

    public boolean hasPath(int a, int b) {

        java.util.Set<Node> reachables = new java.util.HashSet<Node>();
        Node origin = nodeList.get(a);
        Node target = nodeList.get(b);
        walk(origin, reachables);
        return reachables.contains(target);       
    }
}

class Node {

    private java.util.Set<Node> neighbours;

    public Node() {
        neighbours = new java.util.HashSet<Node>();
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }

    public java.util.Set<Node> getNeighbours() {
        return neighbours;
    }
}

class GraphTest {

    private static Graph g;

    public static void main(String[] args) {

        g = new Graph(6);

        g.addEdge(1,5);
        g.addEdge(4,1);
        g.addEdge(4,3);
        g.addEdge(3,6);

        printTest(1, 2);
        printTest(1, 4); 
        printTest(6, 1);   
    }

    public static void printTest(int a, int b) {

        System.out.print("Are nodes " + a + " and " + b + " connected?");
        if (g.hasPath(a, b)) {
            System.out.println(" YES.");
        } else {
            System.out.println(" NO.");
        }
    }
}