public class Node {

    int data;
    Node next;

    public Node(int d) {
        data = d;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}