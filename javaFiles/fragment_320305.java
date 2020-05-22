public static void main(String[] args) throws Exception {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(corePoolSize);
    final String x = "video";
    Callable<Void> yourTask = new Callable<Void>() {
        @Override
        public Void call() throws BindException {
            ConnectionsPanel.singleAddVideos(x);
            return null;
        }
    };
    Future f = scheduler.submit(yourTask);
    boolean added = false; //it will retry until success
                           //you might use an int instead to retry
                           //n times only and avoid the risk of infinite loop
    while (!added) {
        try {
            f.get();
            added = true; //added set to true if no exception caught
        } catch (ExecutionException e) {
            if (e.getCause() instanceof BindException) {
                scheduler.schedule(yourTask, 3, TimeUnit.SECONDS); //reschedule in 3 seconds
            } else {
                //another exception was thrown => handle it
            }
        }
    }
}

public static class ConnectionsPanel {

    private static void singleAddVideos(String connName) throws BindException {
        String newVideosInfo = "";

        for (Iterator<Video> it = ConnectionsPanel.videosToSend.iterator(); it.hasNext();) {
            newVideosInfo = newVideosInfo.concat(it.next().toString());
        }

        MassiveDesktopClient.sendMessage("hi", connName);
        if (MassiveDesktopClient.receiveMessage(connName).matches("hello")) {
            MassiveDesktopClient.sendMessage(newVideosInfo, connName);
        }

        for (Iterator<Video> it = ConnectionsPanel.videosToSend.iterator(); it.hasNext();) {
            MassiveDesktopClient.sendFile(it.next().getAttribute("name"), connName);
        }
    }
}