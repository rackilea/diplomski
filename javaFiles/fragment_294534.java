if (pointer.getLeft() != null) {
    pointer.setRight(pointer.getLeft());
    pointer.setLeft(null);
} else if (!stack.empty()) {
    SearchOperationRequest temp = stack.pop();
    pointer.setRight(temp);
}