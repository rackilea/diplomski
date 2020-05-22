public TreeNode<T>(T data, TreeNode<T> parent) {
    ...
    this.parent = parent;
    int numParentChildren = parent.getNumChildren();
    this.name = parent.getName() + numParentChildren;
}