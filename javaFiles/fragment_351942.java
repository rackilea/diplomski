if (left != null && right != null) {
    return root;
} else {
    if (left == null) {
        return right;
    } else {
        return left;
    }
}