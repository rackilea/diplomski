bootstrap.handler(new ChannelInitializer<SocketChannel>() {
        @Override
        public void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new ObjectEncoder());
            ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
            ch.pipeline().addLast(customHandler1);
            ch.pipeline().addLast(customHandler2);
            ch.pipeline().addLast(customHandler3);
        }
    });