import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {

    private final T data;
    private Node<T> left = null;
    private Node<T> right = null;

    public Node(final T theData) {
        data = theData;
    }

    public void add(final Node<T> theNode) {
        if(data.compareTo(theNode.getData()) <= 0) {
            // goes to the left
            left = theNode;
        } else {
            // goes to the right
            right = theNode;
        }
    }
}