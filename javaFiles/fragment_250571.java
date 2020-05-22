Tree tree1 = tree.left();
if (tree1 != null) {
    findMin(tree1, min);
}

Tree tree2 = tree.right();
if (tree2 != null) {
    findMin(tree2, min);
}