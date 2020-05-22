Tree tree1 = tree.left();
if (tree1 != null) {
    min = findMin(tree1, min);
}

Tree tree2 = tree.right();
if (tree2 != null) {
    min = findMin(tree2, min);
}