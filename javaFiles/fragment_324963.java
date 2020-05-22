final class Gateway extends WebSocketServer {

   private WebSocket _webSocket;

   Gateway( IDataManager dataManager, IConfiguration config) {
      super( new InetSocketAddress( <host>, <port> );
      new Thread( this ).start();
   }

   @Override
   public void onOpen( WebSocket conn, ClientHandshake handshake ) {
      final String request = handshake.getResourceDescriptor();
      final String[] req = request.split( "[/=]" );
      System.out.printf( "request: %s\n", Arrays.toString( req ));
      _webSocket = conn;
      ...
   }

   public void publish( ... ) {
      final ByteBuffer buffer = ByteBuffer.allocate( ... );
      buffer.order( ByteOrder.BIG_ENDIAN );
      buffer.putXXX( ... );
      buffer.flip();
      _webSocket.send( buffer );
   }

   @Override
   public void onMessage( WebSocket conn, String buffer ) {
      System.out.printf( "%s\n", buffer );
   }

   @Override
   public void onMessage( WebSocket conn, ByteBuffer buffer ) {
      try {
         System.out.printf( "%d bytes received from %s",
            buffer.remaining(), conn.getRemoteSocketAddress());
         if( buffer.position() == buffer.limit()) {
            buffer.flip();
         }
         buffer.order( ByteOrder.BIG_ENDIAN );
         final byte xxx = buffer.getXxx();
         ...
      }
      catch( final Throwable t ) {
         t.printStackTrace();
      }
   }

   @Override
   public void onError( WebSocket conn, Exception ex ) {
      ex.printStackTrace();
   }

   @Override
   public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
      System.out.printf( "code: %d, reason: %s, remote: %s\n", code, reason, remote ? "true" : "false" );
   }
}