// saying T must also be Comparable:
// it's possible you are supposed to do
// this for your own Node declaration too
//         vvvvvvvvvvvvvvvvvvvvvvv
class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    T data;

    @Override
    public int compareTo(Node<T> that) {
        return this.data.compareTo( that.data );
    }
}