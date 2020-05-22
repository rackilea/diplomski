public boolean remove(Node node, String s) {
    if (node == null) {
        return false;
    }

    int comparision = s.compareTo(node.data);

    if (comparision == 0) {
        if (node.left == null && node.right == null) {
            System.out.println("----------------------------------");
            if (node.equals(root))
                this.root = null;
            node = null;
            return true;
        } else if (node.left != null && node.right != null) {
            Node temp = node;
            String min = minValue(temp.right).data;
            node.data = min;
            removemin(node.right);
            return true;
        }
    }

    if (comparision < 0) {
        if (node.left.data.equals(s)) {
            if (node.left.left == null || node.left.right == null) {
                node.left = node.left.right;
                return true;
            }
        }
        return remove(node.left, s);
    }

    if (comparision > 0) {
        if (node.right.data.equals(s)) {
            if (node.right.right == null || node.right.left == null) {
                node.right = node.right.left;
                return true;
            }
        }
        return remove(node.right, s);
    }
    return false;
}