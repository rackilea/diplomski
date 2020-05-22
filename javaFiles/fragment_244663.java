public class YourHandler extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelRead (ChannelHandlerContext channelHandlerCtxt, Object msg)
        throws Exception
    {
        // Handle requests as switch cases. GET, POST,...
        // This post helps you to understanding switch case usage on strings:
        // http://stackoverflow.com/questions/338206/switch-statement-with-strings-in-java
        if (msg instanceof FullHttpRequest)
        {
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
            switch (fullHttpRequest.getMethod ().toString ())
            {
                case "GET":
                case "POST":
                ...
            }
        }
    }
}