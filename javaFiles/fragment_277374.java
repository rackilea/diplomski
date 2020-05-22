public class V10String
{
    public int height;
    public String val;
    public AVLTreeNode left,right;

    public V10String() // this constructor assign default values to the members
    {
        this.height = 0;
        this.val    = null;
        this.left   = null;
        this.right  = null;    
    }

    // this constructor assigns to the members values passed to it by the caller
    public V10String(int height, String val, AVLTreeNode left, AVLTreeNode right) 
    {
        this.height = height;
        this.val    = val;
        this.left   = left;
        this.right  = right;
    }
}