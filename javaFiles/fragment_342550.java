public class Test {

    public static void main( String[] args ) {

        Queue<Car> queueForCars = new Queue<>();

        queueForCars.enqueue( new Car( "John" ) );
        System.out.println( queueForCars );
        queueForCars.enqueue( new Car( "Mary" ) );
        System.out.println( queueForCars );
        queueForCars.enqueue( new Car( "Richard" ) );
        System.out.println( queueForCars );
        queueForCars.enqueue( new Car( "David" ) );
        System.out.println( queueForCars );

        System.out.println();

        Queue<Fruit> queueForFruits = new Queue<>();

        queueForFruits.enqueue( new Fruit( "Apple", "red" ) );
        System.out.println( queueForFruits );
        queueForFruits.enqueue( new Fruit( "Banana", "yellow" ) );
        System.out.println( queueForFruits );
        queueForFruits.enqueue( new Fruit( "Lime", "green" ) );
        System.out.println( queueForFruits );

        System.out.println();


    }

}