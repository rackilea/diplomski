final Handler handler = new Handler();
final Runnable runnable = new Runnable() {
    @Override
    public void run() {
        // Do stuff

        handler.postDelayed(this, 2000);
    }
};

handler.postDelayed(runnable, 2000);