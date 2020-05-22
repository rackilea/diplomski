import java.util.LinkedList;
import java.util.Queue;

class WeirdBinaryTree
{
static class Node
{
    private Node right;
    private Node left;
    private int weirdValue;

    public void setWeirdValue(int value)
    {
        weirdValue=value;
    }
}

private static Node makeTree(String str)throws Exception
{
    char[] array=str.toCharArray();
    Node root=new Node();
    Queue<Node> list=new LinkedList();
    list.add(root);
    int i=0;
    Queue<Node> nextList=new LinkedList<Node>();
    while(!list.isEmpty())
    {
        if(array[i++]=='1')
        {                
                Node temp=list.poll();
                temp.left=new Node();
                temp.right=new Node();
                temp.setWeirdValue(1);
                nextList.add(temp.left);
                nextList.add(temp.right);       
        }
        else
        {
            list.poll();
        }
        if(list.isEmpty())
        {
            list=nextList;
            nextList=new LinkedList<Node>();
        }
    }
    return root;
}

private static void postTraversal(Node localRoot)
{
    if(localRoot!=null)
    {
        postTraversal(localRoot.left);
        postTraversal(localRoot.right);
        System.out.print(localRoot.weirdValue);
    }
}

public static void main(String[] args)throws Exception 
{
    postTraversal(makeTree("111001000"));
}
}