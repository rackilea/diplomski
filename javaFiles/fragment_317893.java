ArrayList<Integer> inOrder=new ArrayList<Integer>();

//Method
void Inorder(Node curr)
{
    if(curr!=null)
    {
        if(curr.left!=null)
            Inorder(curr.left);
        inOrder.add(curr.data); //Appending to list
        if(curr.right!=null)
            Inorder(curr.right);
    }
}

//Now after method call:
boolean isBST(ArrayList<Integer> inOrder)
{
    for(int i=1;i<=inOrder.size();i++)
        if(inOrder.get(i)<inOrder.get(i-1)) //Not possible in BST
            return false; 
    return true
}