private int getHeight(Node<T> root){

    int max = 0;
    for (Node<T> childNode  : root.getChildren()) {
        int height = getHeight(childNode);
        if (height > max)
            max = height;
    }
    return max + 1;
}