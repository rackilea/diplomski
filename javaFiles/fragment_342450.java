private String strVal = "";  // StringBuffer would be better

String result = printTree (root);

public String printTree(Node n) {

    if (node.left != null) {
        strVal += node.toString();
        printTree  (node.left);
    }
    if (node.right != null) {
        strVal += node.toString();
        printTree  (node.right);
    }
    return strVal;
}