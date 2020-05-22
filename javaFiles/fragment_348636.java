private static class Node
{

    // Data Fields

    /** The reference to the data. */
    private Music data;
    /** The reference to the next node. */
    private Node next;
    /** The reference to the previous node. */
    private Node prev;

    // Constructors
    /**
    * Creates a new node with null next and previous fields.
    * @param dataItem The data stored
    */
    private Node(Music dataItem)
    {
         data = dataItem;
         next = null;
         prev = null;
    }

/**
 * Creates a new node that references another node.
 * @param dataItem The data stored
 * @param nodeRef The node referenced by new node
 */
    private Node(Music dataItem, Node prevNode)
    {
        Node afterPrevNode = prevNode.next;
        Node node = new Node(dataItem);

        prevNode.next = node;
        prevNode.prev = node;

        node.prev = prevNode;
        node.next = afterPrevNode;
    }
}