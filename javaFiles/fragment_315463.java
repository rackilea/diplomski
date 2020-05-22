public class NettyServer implements Runnable {
final static AttributeKey<Long> CHECKSUMKEY = AttributeKey.valueOf("calcchecksum");
final static AttributeKey<Command> COMMANDKEY = AttributeKey.valueOf("command");
final static AttributeKey<Long> FILEHANDLEKEY = AttributeKey.valueOf("filehandle");
final static AttributeKey<File> PATHKEY = AttributeKey.valueOf("destpath");
final static AttributeKey<FileOutputStream> OUTPUTSTREAM = AttributeKey.valueOf("stream");

@Override
public void run() {
    try {
        EventLoopGroup bossGroup = new NioEventLoopGroup(BOSS_THREADS);
        EventLoopGroup workerGroup = new NioEventLoopGroup(calculateThreadCount());
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            // This option will allow binding to an already bound ip:port
            // combination.
            // This is usually used to be able to restart a server if it
            // crashed/got killed
            // (so while the socket is still in the TIME_WAIT state).
            bootstrap.option(ChannelOption.SO_REUSEADDR, true);
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("ObjectDecoder", new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                    ch.pipeline().addLast("ObjectEncoder", new ObjectEncoder());
                    ch.pipeline().addLast("CommandHandler", new ServerCommandHandler(server, logger));
                    ch.pipeline().addLast("FileHandler", new ServerFileHandler(server, logger));
                    ch.pipeline().addLast("ChecksumHandler", new ServerChecksumHandler(server, logger));
                }
            });

            try {
                // Bind and start to accept incoming connections.
                bootstrap.bind(port).sync().channel().closeFuture().sync();
            } catch (InterruptedException e) {
                logger.debug(Message.CMDTRANSFER_INTERRUPTED_DEBUG, e.getMessage());
            }
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    } catch (Exception e) {
        logger.error(Message.CMDTRANSFER_CONNECT_ERROR, e.getMessage());
    }
}
}