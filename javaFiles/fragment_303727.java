public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) 
{
    String versionCheck = (String)e.getMessage();
    System.out.println("VersionServerHandler - " + versionCheck);
    ctx.getPipeline().remove(VersionServerHandler.class);
}