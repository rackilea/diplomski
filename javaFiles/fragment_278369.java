start = System.currentTimeMillis();
    for( int i=0; i<RUNS; i++ ){
        a1 = a + 'B';
    }
    end = System.currentTimeMillis();
    System.out.println( "a+'B': " + (end-start) + " ms" );