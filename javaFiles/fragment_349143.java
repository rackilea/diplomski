public class TreeNode<T>
{
    private LinkedList<TreeNode<T>> children = new LinkedList<TreeNode<T>>();
    public T value { get; set; }

    public TreeNode(T value)
    {
        this.value = value;
    }
    public LinkedList<TreeNode<T>> GetChildren()
    {
        return children;
    }
}