public class TreeNode<T> implements Iterable<TreeNode<T>> {

    T data;
    TreeNode<T> parent;
    List<TreeNode<T>> children;

    ...

    // A string containing the node name, (e.g. "210")
    String name;


    // A name getter method
    public String getName() {
        return this.name;
    }

    // A method to get the number of children that the node has
    public int getNumChildren() {
        return this.children.size();
    }

}