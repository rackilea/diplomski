private static boolean encryptSearch(char c, BinaryNode curNode, StringBuilder result) {
    char data = curNode.getData();
    if (data != c) {
        boolean found = false;
        if (curNode.hasLeftChild()) {
            found = encryptSearch(c, curNode.getLeftChild(), result);
            if (found) {
                result.insert(0, "0");
                return true;
            }
        }
        if (curNode.hasRightChild()) {
            found = encryptSearch(c, curNode.getRightChild(), result);
            if (found) {
                result.insert(0, "1");
                return true;
            }
        }
        return false; //no result
    }
    return true;
}