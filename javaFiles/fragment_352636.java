@Override
protected void initChannel(SocketChannel ch) {
    pipeline = ch.pipeline();
    pipeline.addLast("encoder", new HttpResponseEncoder());
    pipeline.addLast("decoder", new HttpRequestDecoder());
    pipeline.addLast("aggregator", new HttpObjectAggregator(1024));
    pipeline.addLast("jerseyHandler", jerseyHandler);

}