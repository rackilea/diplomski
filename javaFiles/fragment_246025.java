public void add(String word) {

    //Change the word case to make comparing easier
    word = word.toUpperCase();

    root = recursiveAdd(root, word);
}

/**
 * Takes a sub-tree and recurses until the sub-tree is null (base case)
 * Frequency is incremented if the data is being added, or if
 * it already exists. If the data is not present, the method recurses
 */
private Node recursiveAdd(Node subtree, String word) {

    // Base case: the subtree is null
    if (subtree == null) {
        Node node = new Node();
        node.setStoredWord(word);
        node.incrFreqCount();
        return node;
    }

    int comparison = word.compareTo(subtree.getStoredWord());
    if (comparison == 0) {
        // For data already in tree, increment the frequency
        subtree.incrFreqCount();
    } else if (comparison  < 0) {
        subtree.setLchild(recursiveAdd(subtree.getLchild(), word);
    } else /*if (comparison > 0)*/ {
        subtree.setRchild(recursiveAdd(subtree.getRchild(), word);
    }
    return subtree;
}