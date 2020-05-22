if (root.left != null) {
    return wordExists(root.left, strInput);
}
if (root.right != null) {
    return wordExists(root.right, strInput);
}