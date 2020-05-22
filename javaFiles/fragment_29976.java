// Bind and start to accept incoming connections.
ChannelFuture f = b.bind(PORT).sync();
// Wait until the server socket is closed.
// In this example, this does not happen, but you can do that to gracefully
// shut down your server.
f.channel().closeFuture().sync();