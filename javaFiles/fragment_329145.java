public class Graph implements Iterable<Node> {
    @Override
    public Iterator<Node> iterator() {
        return new DFSIterator(this);
    }
}