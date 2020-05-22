Runnable runnable = new Runnable() {
    public void run () {
        // Do your stuff here
    }
}
Handler handler = new Handler();
handler.postDelayed(runnable, 10000);