static void addNode(node n)
{
    if(root==null)
    {
        root = n;
    }
    else
    {
        node tmp = root; // save the current root
        if(root.getValue()>n.getValue())
        {
            root = root.leftLink;
            addNode(n);
        }
        else if(root.getValue()<n.getValue())
        {
            root = root.rightLink;
            addNode(n);
        }
        root = tmp; // put the root back to its original value
    }
    return;
}