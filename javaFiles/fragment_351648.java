class SocketThread extends Thread {
    private final Handler mHandler;
    private final WifiManager mWifiManager;
    SocketThread(Handler handler, WifiManager wifiManager) {
        mHandler = handler;
    }
    @override public void run() {
        // socket code goes here
        // whenever you receive a part that should update the ui,
        // do something like:
        final String s = new String(dp.getData(),0,dp.getLength());
        mHandler.post(new Runnable() {
            @override
            public void run() {
                update(s);
            }
        });
    }
}