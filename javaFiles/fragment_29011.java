public void addTreeNode(Node parent, Node newChild)
{

    if(parent==null){
        return;
    }
    if(parent.child == null)
     {
        parent.child = newChild;            
        return;
     }

    Node temp = parent.child;

    while(temp.sibling != null)
    {
        temp = temp.sibling;
    }
    temp.sibling = newChild;        

}


public Node find_parentNode(ArrayList<Node> nodes ,int parentID)
{
    for(int i= 0;i<nodes.size();i++)
    {
        if(nodes.get(i).ID == parentID)
            return nodes.get(i);
    }

    return null;
}