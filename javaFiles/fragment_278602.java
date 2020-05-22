public static int maxInTree (Node root)
{
    if (root == null)
        return 0;
    if ((root.getLeftSon() == null) && (root.getRightSon() == null))
        return root.getNumber();
    if (root.getLeftSon() == null)
        return max(root.getNumber(), maxInTree(root.getRightSon()));
    if (root.getRightSon() == null)
        return max(root.getNumber(), maxInTree(root.getLeftSon()));
    return max(root.getNumber(),
        max(maxInTree(root.getLeftSon()),maxInTree(root.getRightSon())));
}

public static int maxInSearchTree (Node r)
{
    if (r == null)
        return 0;
    if (r.getRightSon() == null)
        return r.getNumber();
    return maxInSearchTree(r.getRightSon());
}