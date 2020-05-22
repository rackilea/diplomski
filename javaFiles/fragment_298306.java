AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors
            .newSingleThreadExecutor());
AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(
            new InetSocketAddress(port));

// (insert server.accept() logic here)

// wait until group.shutdown()/shutdownNow(), or the thread is interrupted:
group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);