private class WebsocketWriteThread implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName( "WebsocketWriteThread" );
        try {
            while ( !Thread.interrupted() ) {
                SocketChannelIOHelper.writeBlocking( conn, wrappedchannel );
            }
        } catch ( IOException e ) {
            conn.eot();
        } catch ( InterruptedException e ) {
            // this thread is regularly terminated via an interrupt
        }
    }
}