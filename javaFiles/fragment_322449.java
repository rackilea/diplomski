class Node<T, N extends Node<T, N>> {

    public T data;
    public List<N> children;

    public List<N> getChildren() {
        return children == null ? Collections.<N>emptyList() : children;
    }

    public void addChild(N child) {
        if (children == null) {
            children = new ArrayList<N>();
        }
        children.add(child);
    }
}