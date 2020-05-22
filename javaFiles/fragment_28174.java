public static String longest(TreeNode tree) {
    var flattened = new ArrayList<String>();
    flatten(tree, flattened);
    return Collections.max(flattened, Comparator.comparing(e -> e.length()));
}

public static void flatten(TreeNode tree, ArrayList<String> result) {
    if (tree != null) {
        flatten(tree.left, result);
        result.add((String)tree.value);
        flatten(tree.right, result);
    }
}