@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // ...

    for (Channel ch : channels1) {
        // Does `ch` represent the channel of the current sending client?
        if (ch.equals(ctx.channel())) {
            // Skip.
            continue;
        }

        // Send the message to the `ch` channel.
        // ...
    }

    // ...
}