public static void addChild(int depth, Position<Integer>  currentRoot) {
    Position<Integer> leftChild = currentRoot.insertLeftChild(generateRandomInt());
    Position<Integer> rightChild = currentRoot.insertRightChild(generateRandomInt());
    if(depth > 0) {
        addChild(depth - 1, leftChild);
        addChild(depth - 1, rightChild);
    }
}