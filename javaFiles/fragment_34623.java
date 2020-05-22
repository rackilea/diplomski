// in Node
private Node getLast() { return next == null ? this : next.getLast(); }
public static Node reverse(Node first) {
    Node last = first.getLast();
    reverse(first, null);
    return last;
}

// in main()
System.out.println("before: " + first);
first = Node.reverse(first); // update the value of first afterwards
System.out.println("after: " + first);