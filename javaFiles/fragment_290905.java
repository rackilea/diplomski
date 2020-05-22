public void start() {
    NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(1);
    Bootstrap b = new Bootstrap();
    b.group(nioEventLoopGroup)
     .channel(NioSocketChannel.class)
     .handler(getChannelInitializer());

    this.nioEventLoopGroup = nioEventLoopGroup;
    this.channel = b.connect(host, port).sync().channel();
}

//this method will return execution when client is stopped
public ChannelFuture stop() {
    ChannelFuture channelFuture = channel.close().awaitUninterruptibly();
    //you have to close eventLoopGroup as well
    nioEventLoopGroup.shutdownGracefully();
    return channelFuture;
}