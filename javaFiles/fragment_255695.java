private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    ...

    @Override
    public int compareTo(Node<T> other) {
       return data.compareTo(other.data);
    }
}