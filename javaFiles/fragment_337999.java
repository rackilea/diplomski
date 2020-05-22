public static int maxLevel(BinaryTreeNode tree) {    
    ArrayList<Integer> levels = new ArrayList<Integer>();
    findLevels(tree, 0, levels);
    // now just return the index in levels with the maximal value.
    // bearing in mind that levels could be empty.
}
private static void findLevels(BinaryTreeNode tree, int level,
                                  ArrayList<Integer> levels) {
    if (tree == null) {
        return;
    }
    if (levels.length <= level) {
        levels.add(0);
    }
    levels.set(level, levels.get(level) + tree.getData());
    findLevels(tree.getLeft(), level+1, levels);
    findLevels(tree.getRight(), level+1, levels);
}