public interface Node< T extends Node<T> > {
    public String getId();
    public void add(T node);
    public boolean remove(T node);
}

public class NodeGraph implements Node<NodeGraph> {

    private int row;
    private int column;
    private String id;
    private LinkedList<NodeGraph> neighbourds = new LinkedList<NodeGraph>();

    public NodeGraph(int row, int column) {
        this.row = row;
        this.column = column;
        id = "" + row + column;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void add(NodeGraph node) {
        neighbourds.add(node);
    }

    @Override
    public boolean remove(NodeGraph node) {
        return neighbourds.remove(node);
    }
}