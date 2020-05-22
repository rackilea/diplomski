public static void main(String[] args) {
    Node last = new Node(4, null);
    Node first = new Node(1, new Node(2, new Node(3, last)));

    System.out.println("before: " + first);
    Node.reverse(first);
    System.out.println("after: " + last);
}

private static class Node {
    private int val;
    private Node next;
    public Node(int v, Node n) { val = v; next = n; }
    public String toString() { return val + (next == null ? "" : " -> " + next); }

    public static void reverse(Node first) {
        reverse(first, null);
    }
    private static void reverse(Node p, Node q) {
        if (p.next != null)
            reverse(p.next, p);
        p.next = q;
    }
}