TreeNode root = null;
for (int i=0; i<T.length; ++i) {
    if (T[i] == i) { // if it's a root node
        //TODO: Test for multiple root nodes here
        root = nodes[i];
    } else {
        nodes[T[i]].addChild(nodes[i]);
    }
}