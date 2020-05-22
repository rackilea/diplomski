private void stopChannel() {
 log.trace("Stopping server socket on port '{}'", port);
 sendMessageService.deregisterMessageSender(endpointId);
 try {
   for (Channel channel : channels) {
     if (channel != null) {
       channel.close();
     }
   }
   serverChannel.close().sync();
   log.trace("Server socket on port '{}' stopped.", port);
 } catch (InterruptedException e) {
    throw new RuntimeException(e);
 } finally {
    Future<?> fc = connectionGroup.shutdownGracefully();
    Future<?> fw = workerGroup.shutdownGracefully();
   try {
     fc.await(); // when shutting down in tomcat waits for the netty threads to die
     fw.await();
   } catch (InterruptedException e) {
    throw new RuntimeException(e);
  }
   log.trace("Server workerGroup has shutdown successfully on port '{}'", port);
}