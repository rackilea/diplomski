int count = 1;
try{
    while( true ){
        Thread.sleep( 500 );

        for( int i = 0; i < count; i++ ) System.out.print( "-" );
        System.out.print( "\r" );

        count++;
        if( count >= 30 ) break;
    }
}
catch( Exception e ){
    e.printStackTrace();
}