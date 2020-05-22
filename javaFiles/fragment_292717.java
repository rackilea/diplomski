private static final String NULL_TREE_NODE = "";

public static void save(TreeNode node, BufferedWriter out) {
    if (node == null) {
        out.write(NULL_TREE_NODE); // null
        out.newLine();
        return;
    }
    assert !node.value().equals(NULL_TREE_NODE); // Reserver for us.
    assert !node.value().matches(".*[\r\n].*"); // Newline not allowed in value.
    out.write(node.value()); // these nodes hold Strings
    out.newLine();
    save(node.left(), out);
    save(node.right(), out);
}

public static TreeNode load(BufferedReader in) throws IOException {
    String value = in.readLine();
    if (value == null)
        throw new EOFException(); // Unexpected end of input.
    if (value.equals(NULL_TREE_NODE)) {
        return null;
    }
    TreeNode node = new TreeNode();
    node.value(value);
    node.left(load(in));
    node.right(load(in));
    return node;
}