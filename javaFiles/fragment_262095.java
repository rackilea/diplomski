@Test
public void testLoop() {

    int iteration = 0;
    boolean flag;
    do {
        flag = false; // unused assignment
        ++iteration; // iteration counter
        System.out.println( "Running iteration " + iteration );
    } while ( flag = false );

    System.out.println( "Loop finished. Total number of iterations is " + iteration );
}