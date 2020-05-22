@Override
protected void onPause() {
    ...
    getContentView().removeCallbacks(mCallback);
    mCallback = null;
}