private class BackgroundThread extends HandlerThread {

    private Handler handler;

    public BackgroundThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Looper.prepare();
        backgroundHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                log.finest("DEAService message:" + msg.what);
                switch (msg.what) {
                    //message handling
                }
            }
        };
        MyObject myObject = new MyObject(arg1, arg2);
        myObject.init();
        myObject.attr = myAttr;
        Looper.loop();
    };

    public synchronized void waitUntilReady() {
        handler = new Handler(getMainLooper());
    }
}