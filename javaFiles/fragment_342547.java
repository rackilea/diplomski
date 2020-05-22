public class Test {

    public static void main( String[] args ) {

        QueueForCars queue = new QueueForCars();

        queue.enqueue( new Car( "John" ) );
        System.out.println( queue );
        queue.enqueue( new Car( "Mary" ) );
        System.out.println( queue );
        queue.enqueue( new Car( "Richard" ) );
        System.out.println( queue );
        queue.enqueue( new Car( "David" ) );
        System.out.println( queue );

        System.out.println();

        System.out.println( "Dequeued: " + queue.dequeue() );
        System.out.println( queue );
        System.out.println( "Dequeued: " + queue.dequeue() );
        System.out.println( queue );
        System.out.println( "Dequeued: " + queue.dequeue() );
        System.out.println( queue );
        System.out.println( "Dequeued: " + queue.dequeue() );
        System.out.println( queue );
        System.out.println( "Dequeued: " + queue.dequeue() ); // <- empty queue!
        System.out.println( queue );

    }

}