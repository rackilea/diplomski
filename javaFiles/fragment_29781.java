private class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;
    public Node(T data){
        this.data = data;
        next = null;
    }

}