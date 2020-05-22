setUserTouched(true);
long DELAY = 2000;

final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        // code in here will get executed after DELAY variable
        setUserTouched(false);
    }
}, DELAY);