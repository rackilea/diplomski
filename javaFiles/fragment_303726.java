public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
{
    String verison = "v123.45a";

    ChannelBuffer versionBuffer = ChannelBuffers.buffer(VERSION_STRING_LENGTH);
    versionBuffer.writeBytes(version.getBytes());
    e.getChannel().write(version);
}