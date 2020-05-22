void shutdownWorkers() {
    Future fb = trbossGroup.shutdownGracefully();
    Future fw = workerGroup.shutdownGracefully();
    try {
        fb.await();
        fw.await();
    } catch (InterruptedException ignore) {}
}