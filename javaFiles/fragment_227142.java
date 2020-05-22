@Override
public void  doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
    name = req.getParameter("name");
    for (int i = 10; i < 100; i++) {
        d = com.google.appengine.repackaged.org.joda.time.DateTime.now();
        serverTime = String.valueOf(d.getMillis());
        ChannelMessage channelMessage = new ChannelMessage("logger", i+ " Message..... " + name + " Server Time: " + serverTime + " Client Time:");
        getChannelService().sendMessage(channelMessage);
    }
}