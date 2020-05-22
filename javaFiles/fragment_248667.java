public static void main(String[] args) {
    Node head1 = new Node(6);
    head1.next = new Node(8);
    // ...
    Node head2 = new Node(2);
    head2.next = new Node(7);
    // ...
    Node newHead = merge(head1, head2);