mELV_PredefinedFruit.post(new Runnable() {
    @Override
    public void run() {
        int numberOfChildViews = mELV_PredefinedFruit.getChildCount();
        Log.d(LOG_CLASS, String.format(Locale.US, "%s number of child views in ELV:  %d", METHOD, numberOfChildViews));
    }
});