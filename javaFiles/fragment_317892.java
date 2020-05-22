class Node //The node for the BSt should look something like this 
{
    Node left, right;
    int data;
    Node(Node left, Node right, int data)
    {
        this.left=left;
        this.right=right;
        this.data=data;
    }
}

<br>

//Method for inserting into the BST
void Insert(Node curr, int value, String where, int tillWhere)
{
    if(curr==null)
        curr=new Node(value);
    else
    {
        if(where.charAt(tillWhere)=='L')
            Insert(curr.left, value, where, tillWhere+1);
        else
            Insert(curr.right, value, where, tillWhere+1);
    }
}