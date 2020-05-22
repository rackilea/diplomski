void updateDepth(Node node, int depth)
{
    if (node != null)
    {
        node.depth = depth;
        updateDepth(node.left, depth + 1); // left sub-tree
        updateDepth(node.right, depth + 1); // right sub-tree
    }
}