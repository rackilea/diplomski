handler = new Handler();

runnable = new Runnable() {
    @Override
    public void run() {
        handler.postDelayed(this, 5000);
    }
}

handler.post(runnable);