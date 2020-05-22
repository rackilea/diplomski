public class Tree {
    public Node head = new Node();

    public void insert(int n , Node m)
    {
        if(m == head && head.data == -1) 
        {
            // if we have an empty tree, just change the head
            head.data = n;
        }
        else if(m.data > n) {
            // we should be adding to the left subtree here
            if(m.left == null) {
                // if no left subtree, create a new node and link to m's left
                m.left = new Node(n);
            }
            else {
                // otherwise call insert on left subtree recursively
                insert(n, m.left);
            }
        }
        else
        {
            // otherwise add to right subtree
            if(m.right == null) {
                // no right subtree, so create node and link to m's right
                m.right = new Node(n);
            }
            else {
                // call recursively
                insert(n, m.right);
            }
        }
    }
    public void print()
    {
        System.out.println(head.data);
        System.out.println(head.left.data);
        System.out.println(head.right.data);
    }
}