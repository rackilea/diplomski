class QueueSimulation
 {
     public static void main(String[] args) {
        for ( int test = 0; test < 3; test ++ ) {
           QueueSimulation sim = new QueueSimulation();
           sim.simulate();
           sim.report();
        }
     }


     Queue<Customer> q = new LinkedList<Customer>();
     int numServed = 0;
     ...
     int totalProcessingTime = 0;

     public void simulate() {
         for ( int i = 0; i < 1000 ) {
             ....
         }
     }

     public void report() {
         System.out.println( ....
         ...           
     }
 }