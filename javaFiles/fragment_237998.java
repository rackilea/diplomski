Bootstrap bootstrap = new Bootstrap()
            .group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .remoteAddress(new InetSocketAddress(remoteAddress, port))
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout);

ChannelFuture f = bootstrap.connect();