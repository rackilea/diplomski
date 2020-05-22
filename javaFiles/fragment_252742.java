public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int roads = sc.nextInt(); // How many Edges we have
        int vertices = sc.nextInt(); // How many vertices Graph has
        Graph<String> g = new Graph<String>(vertices); // Every Vertex is a
                                                        // String
        for (int i = 0; i < roads; i++) {
            g.add(sc.next(), sc.next());
        }
        // Here i get an error
        Edge<String> e; // Edge cannot be resolved to a type
    }

    static class Graph<E> {
        HashMap<E, Edge<E>> m;

        public Graph(int vertices) {
            m = new HashMap<E, Edge<E>>(vertices);
        }

        public void add(E from, E to) {
            if (m.get(from) == null)
                m.put(from, new Edge<E>(to, null));
            else
                m.put(from, new Edge<E>(to, m.get(from)));
        }
    }

    // Storing Graph as an adjacent list of edges
    static class Edge<E> {
        E to;
        Edge<E> prev;

        public Edge(E to, Edge<E> prev) {
            this.to = to;
            this.prev = prev;
        }
    }
}