public class MyHandler extends SimpleChannelUpstreamHandler {
    ....

    @Override
    public void channelInterestChanged(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        if (e.getChannel().isWritable() {
            .....
        }
    }
}