public static void main( String [] args ) {

    System.out.println( "Starting Main" ) ;
        Thread numberThread;
        for ( int i = 1 ; i <= 5 ; i++ ) {
            numberThread = new Thread(new NumberTask(i)) ;
            numberThread.start() ;
        }
        numberThread.join();
        System.out.println( "Ending Main" ) ; 
    }