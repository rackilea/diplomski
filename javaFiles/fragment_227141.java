@Override
public void  doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    name = req.getParameter("name");
    List<Future> waits = new ArrayList<>(90);
    ExecutorService executors = Executors.newFixedThreadPool(50, ThreadManager.currentRequestThreadFactory());
    for (int i = 10; i < 100; i++) {
       waits.add(executors.submit(new Callable<Boolean>() {
           Boolean call() { 
                d = com.google.appengine.repackaged.org.joda.time.DateTime.now();
                serverTime = String.valueOf(d.getMillis());
                ChannelMessage channelMessage = new ChannelMessage("logger", i+ " Message..... " + name + " Server Time: " + serverTime + " Client Time:");
                getChannelService().sendMessage(channelMessage);
                return true;
            }

        }))
    }
    for (Future f: waits) {
       f.get()
    }

}