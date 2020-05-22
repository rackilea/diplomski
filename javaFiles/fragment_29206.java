public Node getParent(int search, Node position) 
{
    // check for null argument, so the caller doesn't have to
    if (position == null) return null;

    // we'll need these child nodes below
    Node left = position.getLeft(), right = position.getRight();

    // step 1: if either child matches the target, return this node
    if (left != null && left.getContent() == search) return position;
    if (right != null && right.getContent() == search) return position;

    // step 2: recursively check left subtree
    Node leftMatch = getParent(search, left);
    if (leftMatch != null) return leftMatch;

    // step 3: recursively check right subtree
    Node rightMatch = getParent(search, right);
    if (rightMatch != null) return rightMatch;

    // no match
    return null;
}