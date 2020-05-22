boolean jamesIsRunning = new Socket().with {
    try { 
        connect( new InetSocketAddress( 'localhost', 4555 ), 100 )
        close()
        true
    }
    catch( e ) {
        false
    }
}