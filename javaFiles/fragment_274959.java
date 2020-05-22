if (className.endsWith(currentPlugin.messageListner)) {
    new Thread(new Runnable() {

            @Override
            public void run() {
                //your thread code
                 TestMessageListener messageListner = null;
                    messageListner = (TestMessageListener) c.getConstructor(MessageBus.class, String.class)
                            .newInstance(messageBus, currentPlugin.initParam);
                    if (messageListner.start() == false) {
                        currentPlugin.loadStatus = "failed";
                        currentPlugin.errorCode = "Plugin start failed.";
                    } else {
                        currentPlugin.loadStatus = "success";
                        currentPlugin.errorCode = "";
                    }

            }
        }).start();//starting the thread
}