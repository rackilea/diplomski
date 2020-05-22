log.info(context.pipeline().toMap());
context.writeAndFlush(CONNECT_RESPONSE).addListener(new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
               log.info("WriteandFlush : " + future.isSuccess());
        }
});

the output would be 
INFO  test.InboundFrontHandler  - {InboundFrontHandler#0=test.InboundFrontHandler@1f060469, HttpRequestDecoder#0=io.netty.handler.codec.http.HttpRequestDecoder@1c3c34f6, HttpResponseEncoder#0=io.netty.handler.codec.http.HttpResponseEncoder@7333cf2a, DEFLATER_HANDLER=io.netty.handler.codec.http.HttpContentCompressor@3d7fa45b}
INFO  test.InboundFrontHandler  - WriteandFlush : false