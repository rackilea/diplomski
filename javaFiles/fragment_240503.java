class Server {
     private static Selector selector;
     public static void main(String[] args) throws Exception {
          ServerSocketChannel ssc = ServerSocketChannel.open();
          ssc.configureBlocking(false);
          Selector selector = Selector.open();
          ssc.register(selector, SelectionKey.OP_ACCEPT);

          while(true) {
               selector.select();

               while(selector.iterator().hasNext()) {
                    SelectionKey key = selector.iterator().next();

                    if(key.isAcceptable()) {
                         accept(key);
                    }
               }
          }
     }

     private static void accept(SelectionKey key) throws Exception {
          ServerSocketChannel channel = (ServerSocketChannel) key.channel();
          SocketChannel sc = channel.accept();
          sc.register(selector, OP_READ);
     }
}