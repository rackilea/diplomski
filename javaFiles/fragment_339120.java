try {
    CompletableFuture<Boolean> future = new CompletableFuture<Boolean>();

    AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
    channel.connect(new InetSocketAddress("www.yahoo.com", 80),
            null, new CompletionHandler<Void, Object>() {
                @Override
                public void completed(Void result, Object attachment) {
                    System.out.println("Connected");

                    ByteBuffer buffer = ByteBuffer.wrap("GET http://www.yahoo.com HTTP/1.1\r\n\r\n".getBytes());
                    channel.write(buffer, null, new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {
                            System.out.println("Write completed: " + result.toString());

                            ByteBuffer buffer = ByteBuffer.allocate(23);

                            channel.read(buffer, null, new CompletionHandler<Integer, Object>() {
                                @Override
                                public void completed(Integer result, Object attachment) {
                                    System.out.println("Read completed: " + result.toString());
                                    System.out.println(new String(buffer.array()));

                                    // 
                                    future.complete(true);
                                }

                                @Override
                                public void failed(Throwable exc, Object attachment) {
                                    exc.printStackTrace();
                                    //
                                    future.complete(false);
                                }
                            });
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            exc.printStackTrace();
                            //
                            future.complete(false);
                        }
                    });
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    exc.printStackTrace();
                    //
                    future.complete(false);
                }
            });
    // Wait until the other Threads are finished
    System.out.println("Successs: "+future.get(10, TimeUnit.SECONDS));
    channel.close();
} catch (Exception ex) {
    ex.printStackTrace();
}