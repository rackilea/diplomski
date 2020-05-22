public String toString1(Node node)
{
    Node currentNode = node;
    if (currentNode == null) {
        return "\b";
    }
    int i = currentNode.data;
    String str = Integer.toString(i);
    if (currentNode.next != null) {
        str = str
            + "," + toString1(currentNode.next);
    } 
    return str;
}