Handler handler = new Handler(Looper.getMainLooper());
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        // write here what you want to happen in 10 seconds on the UI thread
    }
}, 10000); // 10s = 10,000ms