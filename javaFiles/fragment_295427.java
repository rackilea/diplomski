final Handler handler = new Handler();
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        // Do what you need to do
    }
}
handler.postDelayed(runnable, 10_000 /* Wait 10 seconds */);