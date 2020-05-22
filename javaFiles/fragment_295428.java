final Handler handler = new Handler();
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        // Stop what you want to stop
    }
}
handler.postDelayed(runnable, 2*60*1000 /* Wait 2 minutes */);