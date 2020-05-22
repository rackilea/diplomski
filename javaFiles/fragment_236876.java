@Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        SSLEngine sslEngine = ApiServer.this.sslContext.createSSLEngine();
        sslEngine.setNeedClientAuth(false);
        sslEngine.setUseClientMode(false);
        SslHandler sslHandler = new SslHandler(sslEngine);
        ctx.pipeline().addFirst(sslHandler);
    }