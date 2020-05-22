public class MyHandler extends SimpleChannelInboundHandler{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {


        try {
            System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
        } finally {
            in.release();
        }


    }
}