public boolean contains(int aData, Node node)
{
    Node currentNode = node;
    // base case; if this node is null, return false
    if(currentNode == null) {
        return false;
    }
    // if this node contains the data, return true, otherwise, check next nodes.
    if(currentNode.data == aData) {
        return true;
    } else {
        return contains(aData, currentNode.next);
    }
}