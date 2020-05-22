for (ConnectionInfo connectionInfo : HOSTS) {
    new Thread() {
    public void run() {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
        Bootstrap b = new Bootstrap();
        // ....... etc
        } finally {
        // Shut down the event loop to terminate all threads.
        group.shutdownGracefully();
        }
    }
    }.start();
}