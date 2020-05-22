uiThreadHandler.postDelayed(new Runnable() {
    @Override
    public void run() {
        workLoop(index + 1);
    }
}, 5000);