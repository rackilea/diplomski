class Server {
     public static void main(String[] args) throws Exception {
          ServerSocketChannel ssc = ServerSocketChannel.open();
          ssc.configureBlocking(false);

          while(true) {
               SocketChannel sc = ssc.accept();

               if(sc != null) {
                    //handle channel
               }
          }
     }
}