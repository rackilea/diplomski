/* The Node class is defined as follows:

        class Node {
        int data;
        Node left;
        Node right;
         }
    */
        boolean checkBST(Node root) {
            return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        }

        private boolean isValidBSTHelper(Node root, int min, int max) {

            if (root == null) return true;
            if (root.data > max || root.data < min) return false;
            return (isValidBSTHelper(root.left, min, root.data) &&  isValidBSTHelper(root.right, root.data, max));