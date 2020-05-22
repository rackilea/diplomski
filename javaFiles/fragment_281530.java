HomeWatcher mHomeWatcher = new HomeWatcher(this);
mHomeWatcher.setOnHomePressedListener(new OnHomePressedListener() {
    @Override
    public void onHomePressed() {
        // do something here...
    }
    @Override
    public void onHomeLongPressed() {
    }
});
mHomeWatcher.startWatch();