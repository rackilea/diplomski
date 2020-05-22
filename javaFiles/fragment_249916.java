ServerBootstrap serverBootstrap = new ServerBootstrap();
serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
    .option(ChannelOption.SO_BACKLOG, 100)
    .childOption(ChannelOption.SO_KEEPALIVE, true)
    .handler(new LoggingHandler(LogLevel.DEBUG))
    .childHandler(new ResponseHandler());