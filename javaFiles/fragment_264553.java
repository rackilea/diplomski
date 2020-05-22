void leftRotate(RBNode node)
{
    RBNode y;
    y = node.right;
    node.right = y.left;

    if(y.left != null)y.left.parent = node;

    y.parent = node.parent;

    if(node.parent == null)root = y;
    else
    {
        if(node == node.parent.left)node.parent.left = y;
        else node.parent.right =y;
    }
    y.left = node;
    node.parent = y;
}

void rightRotate(RBNode node)
{
    RBNode y;
    y = node.left;
    node.left = y.right;
    if(y.right != null)y.right.parent = node;

    y.parent = node.parent;

    if(node.parent == null)root = y;
    else
    {
        if(node == node.parent.right)node.parent.right = y;
        else node.parent.left =y;
    }
    y.right = node;
    node.parent = y;
}