public static void main( String ... args ) throws Exception{

    for (int i = 0; i < 1000; i++) {
        System.gc();
        Thread.sleep( 2000 );
        System.out.println("start test ==>");
        testDispatchAndPersistence( true );
        //testOffHeapPersistence();
    }