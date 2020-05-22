public static ArrayList<Integer> printPath(TreeNode node, ArrayList<Integer> path, int value) {
    if (node == null)
        return path;

    path.add(node.data);

    int cmp = Integer.compare(value, node.data);

    if (cmp < 0) // value is smaller, so go left
        printPath(node.left, path, value);
    else if (cmp > 0) // value is larger, so go right
        printPath(node.right, path, value);
    else /* if (cmp == 0) */
         return path; // value found

    return path;
}