public class Edge {
    final int source;
    final int next;

    Edge(int source, int next) {
        this.source = source;
        this.next = next;
    }

    @Override
    public String toString() {
        return "(" + source + "," + next + ')';
    }
}