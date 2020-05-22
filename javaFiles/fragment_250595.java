import java.util.HashSet;
import java.util.Set;

public class Node {

    private int value;
    private Set<Node> adjacentNodes = new HashSet<Node>();

    public Node(int x) {
        value = x;
    }
    public void addAdjacentNode(Node node) {
        adjacentNodes.add(node);
    }
    public int getValue() {
        return value;
    }

    public void setValue(int values) {
        this.value = values;
    }

    public Set<Node> getNodes() {
        return adjacentNodes;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (value != other.value)
            return false;
        return true;
    }
}