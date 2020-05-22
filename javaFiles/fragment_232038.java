handler.postDelayed(new Runnable() {

    public void run() {
        retrieveMsgs(next);
    }
}, 240000);