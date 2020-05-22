public ChannelPipeline getPipeline() throws Exception {
    // Create a default pipeline implementation.
    ChannelPipeline pipeline = pipeline();

    // Uncomment the following line if you want HTTPS
    SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();
    engine.setUseClientMode(false);
    engine.setNeedClientAuth(true);
    pipeline.addLast("ssl", new SslHandler(engine));

    pipeline.addLast("decoder", new HttpRequestDecoder());
    pipeline.addLast("logger", new RequestAuditLogger());
    // Uncomment the following line if you don't want to handle HttpChunks.
    pipeline.addLast("aggregator", new HttpChunkAggregator(1048576));
    pipeline.addLast("outputLogger", new ResponseAuditLogger());
    pipeline.addLast("encoder", new HttpResponseEncoder());
    // Remove the following line if you don't want automatic content compression.
    pipeline.addLast("deflater", new HttpContentCompressor());
    pipeline.addLast("handler", new HttpSnoopServerHandler());
    return pipeline;
}
}