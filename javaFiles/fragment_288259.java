// Ports.
int serverPort = 8080;

ChannelGroup allChannels =
         new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

EventLoopGroup bossGroup    = new NioEventLoopGroup();
EventLoopGroup workerGroup  = new NioEventLoopGroup();
try {
    ServerBootstrap b = new ServerBootstrap();
    b.group(bossGroup, workerGroup)
     .channel(NioServerSocketChannel.class)
     .childHandler(new ChannelInitializer<SocketChannel>() {
         @Override
         public void initChannel(SocketChannel ch) throws Exception {
             ch.pipeline().addLast("MyMessageHandler", new MyMessageHandler());
             ch.pipeline().addLast("grouper", new GlobalSendHandler());
         }
     })
     .option(ChannelOption.SO_BACKLOG, 128)
     .childOption(ChannelOption.SO_KEEPALIVE, true);

    // Bind and start to accept incoming connections.
    ChannelFuture f = b.bind(serverPort).sync();
    Channel ch = f.channel();

    System.out.println("Server: Running!");

  // Read commands from the stdin.
  ChannelGroupFuture lastWriteFuture = null;
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  while(true)
  {
      String line = in.readLine();
      if (line == null) break;

      ByteBuf getOut = buffer(64);
      getOut.writeBytes(line.getBytes());

      // Sends the received line to the server.
      lastWriteFuture = allChannels.writeAndFlush(getOut);

      lastWriteFuture.addListener(new ChannelGroupFutureListener() {
            @Override
            public void operationComplete(ChannelGroupFuture cf) throws Exception {
                if(cf.isSuccess()) {
                    System.out.println("CFListener: SUCCESS! YEAH! HELL! YEAH!");
                } else {
                    System.out.println("CFListener: failure! FAILure! FAILURE!");
                    System.out.println(cf.cause());
                }
            }
        });

  }

           // Wait until all messages are flushed before closing the channel.
  if (lastWriteFuture != null) {
      lastWriteFuture.sync();
  }


    // Wait until the server socket is closed.
    // In this example, this does not happen, but you can do that to gracefully
    // shut down your server.
    f.channel().closeFuture().sync();
} catch (InterruptedException | UnsupportedOperationException e) {
    e.printStackTrace();
} finally {
    workerGroup.shutdownGracefully();
    bossGroup.shutdownGracefully();
}