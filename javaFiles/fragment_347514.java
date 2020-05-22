private class SizedNode {
    public long cumulativeSize;
    public Node node;
    public SizedNode parent;

    public SizedNode(SizedNode parent, Node node) {
        this.node = node;
        this.parent = parent;
    }

    public long getSize() {
        if (node.hasChildren()) {
            return cumulativeSize;
        }
        else {
            return node.size();
        }
    }
}

private void sumUpAndCacheChildren(Node start)
{
    Stack<SizedNode> nodeStack = new Stack<SizedNode>();

    // Let's start with the beginning node.
    nodeStack.push(new SizedNode(null, start));

    // Loop as long as we've got nodes to process
    while (!nodeStack.isEmpty()) {

        // Take a look at the top node
        SizedNode sizedNode = nodeStack.peek();            
        CacheEntry entry = getCacheEntry(sizedNode.node);

        if (entryIsValid(entry)) {
            // It's cached already, so we have computed its size
            nodeStack.pop();

            // Add the size to the parent, if applicable.
            if (sizedNode.parent != null) {
                sizedNode.parent.cumulativeSize += sizedNode.getSize();

                // If the parent's now the top guy, we're done with it so let's cache it
                if (sizedNode.parent == nodeStack.peek()) {
                    putInCache(sizedNode.parent.node, sizedNode.parent.getSize());
                }
            }
        }
        else {
            // Not cached.
            if (sizedNode.node.hasChildren()) {
                // It's got a bunch of children.
                // We can't compute the size yet, so just add the kids to the stack.
                Node[] children = sizedNode.node.listChildren();
                if (children != null) {
                    for (Node child : children) {
                        nodeStack.push(new SizedNode(sizedNode, child));
                    }    
                }                    
            }
            else {
                // It's a leaf node. Let's cache it.
                putInCache(sizedNode.node, sizedNode.node.size());
            }
        }
    }
}