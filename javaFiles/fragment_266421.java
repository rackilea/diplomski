HttpClient.create()
        .doOnResponse((res, conn) ->
                    conn.channel().pipeline().addBefore(NettyPipeline.HttpDecompressor, "myhandler",new ChannelInboundHandlerAdapter() {
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            if (msg instanceof HttpContent) {
                                System.out.println("received:" + msg);
                            }
                            super.channelRead(ctx, msg);
                        }
                    }))
        .doAfterResponse((res, conn) ->
                    conn.channel().pipeline().remove("myhandler"))
        .compress(true)