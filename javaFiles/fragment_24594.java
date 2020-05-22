private static int level = 0;    
public void displayFiles(T node)
{
    Node temp = node;

    if (temp != null && temp.leftChild != null && temp.rightChild != null)
    {
     ++level;
        displayFiles(temp.leftChild);
        displayFiles(temp.rightChild);
    }
    --level;
}