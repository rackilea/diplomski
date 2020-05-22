else {
    Node<T> result = search(node.getChildren().get(i), parentRef);
    if (result != null) {
        return result;
    }
}