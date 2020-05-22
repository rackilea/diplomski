public class MyLastHandler extends SimpleInboundHandler<String> {
    private final SynchronousQueue<Promise<String>> queue;

    public MyLastHandler (SynchronousQueue<Promise<String>> queue) {
        super();
        this.queue = queue;
    }

    // The following is called messageReceived(ChannelHandlerContext, String) in 5.0.
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) {
        this.queue.remove().setSuccss(msg); 
        // Or setFailure(Throwable)
    }
}