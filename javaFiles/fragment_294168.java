// Inorder traversal:
// Keep the nodes in the path that are waiting to be visited
Stack s = new Stack(); 
// The first node to be visited is the leftmost
Node node = root;
while (node != null)
{
    s.push(node);
    node = node.left;
}
// Traverse the tree
while (s.size() > 0)
{
    // Visit the top node
    node = (Node)s.pop();
    System.out.println((String)node.data);
    // Find the next node
    if (node.right != null)
    {
        node = node.right;
        // The next node to be visited is the leftmost
        while (node != null)
        {
            s.push(node);
            node = node.left;
        }
    }
}