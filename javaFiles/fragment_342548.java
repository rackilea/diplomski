public class Queue<Type> {

    private class Node<Type> {
        Type value;
        Node<Type> previous;
    }

    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public Queue() {
        tail = null;
        head = null;
        size = 0;
    }

    public void enqueue( Type value ) {

        Node<Type> newNode = new Node<>();
        newNode.value = value;
        newNode.previous = null;

        if ( isEmpty() ) {
            head = newNode;
            tail = newNode;
        } else {
            tail.previous = newNode;
            tail = newNode;
        }

        size++;

    }

    public Type dequeue() {

        if ( !isEmpty() ) {

            Type value = head.value;

            if ( head == tail ) {
                head = null;
                tail = null;
            } else {
                Node<Type> temp = head;
                head = head.previous;
                temp.previous = null;
            }

            size--;
            return value;

        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if ( !isEmpty() ) {

            Node<Type> current = head;

            while ( current != null ) {

                if ( size == 1 ) {
                    sb.append( current.value ).append( " <- head/tail\n" );
                } else if ( current == head ) {
                    sb.append( current.value ).append( " <- head\n" );
                } else if ( current == tail ) {
                    sb.append( current.value ).append( " <- tail\n" );
                } else {
                    sb.append( current.value ).append( "\n" );
                }

                current = current.previous;

            }

        } else {
            sb.append( "empty queue!\n" );
        }

        return sb.toString();

    }

}