protected void onCreate(Bundle savedInstanceState) {
    ht = new HandlerThread("HT");
    ht.start();
    htHandler = new Handler(ht.getLooper(), htCallback);
    mainHandler = new Handler(mainCallback);
    for (int i = 0; i < 10; i++) {
        htHandler.sendMessageDelayed(htHandler.obtainMessage(99, i, 0), i * 3000);
    }
}

private HandlerThread ht;
private Handler htHandler;
private Handler mainHandler;

private Callback htCallback = new Callback() {
    @Override
    public boolean handleMessage(Message msg) {
        Log.d(TAG, "handleMessage **********************");
        Log.d(TAG, "handleMessage " + msg);
        Log.d(TAG, "handleMessage Thread: " + Thread.currentThread());
        if (msg.arg1 == 4) {
            Log.d(TAG, "handleMessage sending back to Main thread");
            mainHandler.sendEmptyMessage(101);
        }
        return false;
    }
}; 

private Callback mainCallback = new Callback() {
    @Override
    public boolean handleMessage(Message msg) {
        Log.d(TAG, "handleMessage ########################");
        Log.d(TAG, "handleMessage " + msg);
        Log.d(TAG, "handleMessage Thread: " + Thread.currentThread());
        Log.d(TAG, "handleMessage i'm quitting");
        ht.quit();
        return false;
    }
};