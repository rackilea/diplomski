public class Node
{
    long key;
    Node lChild;
    Node rChild;
}

public void DelLargest()
{
    Node gpnode = null;
    Node pnode = null;
    Node node = root;
    while(node != null) // keep going right until a null is reached
    {
        gpnode = pnode;
        pnode = node;
        node = node.rChild;
    }
    if(pnode.lChild == null) // its a leaf node So change the edge (gpnode,pnode) to (gpnode,null)
    {
        if(gpnode.lChild == pnode)
        {
            gpnode.lChild = null;
        }
        else
        {
            gpnode.rChild = null;
        }
    }
    else // copy lChild's key to this node and delete lChild
    {
        if(gpnode.lChild == pnode)
        {
            gpnode.lChild = pnode.lChild;
        }
        else
        {
            gpnode.rChild = pnode.lChild;
        }
    }   
}