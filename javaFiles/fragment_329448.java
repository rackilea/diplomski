runThreadA() {
    maxTimeout = currentTime() + REASONABLE_TIMEOUT
    while ( currentTime() < maxTimeout ) { 
       socket.connect()
       if ( isConnected( socket ) ) { 
           break;
       }
       Thread.currentThread.sleep( A_WHILE )
    }
    if ( ! isConnected( socket ) ) { 
        .... too bad, we can't work this way
        exit();
    } 
    continue with the work here...
}