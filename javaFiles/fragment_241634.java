public void channelRead(ChannelHandlerContext ctx, Object msg) /* throws Exception */
    TextWebSocketFrame frame = (TextWebSocketFrame) msg;
    try {
        /* Remaining code, follow the steps further of see end result */
    } finally {
        frame.release();
    }
}