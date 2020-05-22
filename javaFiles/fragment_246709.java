Runnable runnable = new Runnable() {
    @Override
    public void run() {
        changesColorsToGreenOrRed();
    }
};
mHandler.postDelayed(runnable, 2000);