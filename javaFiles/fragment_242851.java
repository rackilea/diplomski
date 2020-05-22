/* Class BST */
class BST
{
 private Node root;
 private int iterations;

... 

  /* Functions to search for an element */
public boolean search(int val) 
{
    iterations=0;
    iterations++;
    return search(root, val);
}

/* Function to search for an element recursively */
private boolean search(Node r, int val) 
{
    iterations=0;
    ...
    return found;
}

public int getLastIterationCount(){
    return iterations;
}

}