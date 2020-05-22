// Start the client.
ChannelFuture f = b.connect(connectionInfo.getHost(), connectionInfo.getPort());
f.addListener(new ChannelFutureListener() {
    @Override
    public void operationComplete(ChannelFuture future) {
    if (future.isSuccess()) {
        // connection complete start to read first data
        LOG.log(Level.INFO, "Connected to {0}:{1} successfully.",
            new Object[]{connectionInfo.getHost(), connectionInfo.getPort().toString()});
    } else {
        // Close the connection if the connection attempt has failed.
        LOG.log(Level.WARNING, "Connection problem to {0}:{1}.",
            new Object[]{connectionInfo.getHost(), connectionInfo.getPort().toString()});
    }
    }
});
// Wait until the connection is closed.
f.channel().closeFuture().sync();