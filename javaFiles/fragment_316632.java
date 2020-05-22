private Node insert(Node head, int data)
{
    Node node = new Node(data);

    if (head != null) {
        node.nextLink = head;
    }

    head = node;

    return head;
}