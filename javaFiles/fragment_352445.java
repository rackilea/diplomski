public void moveDown() {
    int currentDepth = elementStack.size();
    while (elementStack.size() <= currentDepth) {
        move();
        if (elementStack.size() < currentDepth) {
            throw new RuntimeException(); // sanity check
        }
    }
}