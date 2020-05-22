public class QueueForCars {

    private class Node {
        Car value;
        Node previous;
    }

    private Node head;
    private Node tail;
    private int size;

    public QueueForCars() {
        tail = null;
        head = null;
        size = 0;
    }

    public void enqueue( Car value ) {

        Node newNode = new Node();
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

    public Car dequeue() {

        if ( !isEmpty() ) {

            Car value = head.value;

            if ( head == tail ) {
                head = null;
                tail = null;
            } else {
                Node temp = head;
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

            Node current = head;

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