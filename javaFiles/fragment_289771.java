Handler handler = new Handler();

private Runnable runnable = new Runnable () {
    @Override
    public void run() {
        OnTimer(); // Run your code
        handler.postDelayed(this, 1000); // re-run this Runnable object in 1 second
   }  
}

handler.post(runnable); // run the Runnable object now