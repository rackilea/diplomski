public class Graph<T> {

    private Set<Node<T>> nodes;
    private Set<Edge<T>> edges;

    private class Node<T> {
        private T value;
    }

    private class Edge<T> {
        private Node<T> to;
        private Node<T> from;
        private Number cost;
    }
}