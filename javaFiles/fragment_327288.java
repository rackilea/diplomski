class Node { }
public class List {
    Node first;

    public int length() {
        if (first == null) {
            return 0;
        } else {
            List tail = new List(first.next);
            return 1 + tail.length();
        }
    }